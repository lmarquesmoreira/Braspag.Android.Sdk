package br.com.braspag.sdk.core.network

import br.com.braspag.sdk.core.toStatusCode
import okhttp3.Interceptor
import retrofit2.Response

fun String.addBearerFormat(): String = "Bearer $this"

fun <T> createRequest(
    url: String,
    type: Class<T>,
    additionalInterceptors: List<Interceptor>? = null
): T =
    RestProvider(url)
        .createService(type, additionalInterceptors)

fun <T> processRequest(block: () -> Response<T>): ClientResultModel<T> {
    val response = block.invoke()
    return when (response.isSuccessful) {
        true -> ClientResultModel(
            response.body(),
            response.code().toStatusCode(),
            requestId = response.headers().get("requestid")
        )
        false -> ClientResultModel(
            null,
            response.code().toStatusCode(),
            response.errorBody()?.string(),
            requestId = response.headers().get("requestid")
        )
    }
}
