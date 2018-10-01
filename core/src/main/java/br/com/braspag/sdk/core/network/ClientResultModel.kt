package br.com.braspag.sdk.core.network

import br.com.braspag.sdk.core.http.HttpStatusCode

data class ClientResultModel<T>(
        val result: T?,
        val statusCode: HttpStatusCode,
        val messageError: String? = null,
        val requestId: String? = null
) {
    fun isSuccess(): Boolean = statusCode.code in 200..299
}