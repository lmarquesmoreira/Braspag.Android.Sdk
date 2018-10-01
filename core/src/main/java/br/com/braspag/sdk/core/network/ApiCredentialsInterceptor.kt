package br.com.braspag.sdk.core.network

import br.com.braspag.sdk.core.ApiCredentials
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

class ApiCredentialsInterceptor(val credentials: ApiCredentials) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val authenticatedRequest = request.newBuilder()
            .header("Authorization", "Bearer ${credentials.accessToken}")
            .header("MerchantId", credentials.merchantId)
            .header("RequestId", UUID.randomUUID().toString())
            .build()
        return chain.proceed(authenticatedRequest)
    }
}