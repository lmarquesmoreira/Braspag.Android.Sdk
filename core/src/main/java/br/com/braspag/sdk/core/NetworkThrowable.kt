package br.com.braspag.sdk.core

import br.com.braspag.sdk.core.http.HttpStatusCode

data class NetworkThrowable(
    override val message: String,
    val statusCode: HttpStatusCode, val parent: Throwable?
) : Throwable(message, parent)