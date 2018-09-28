package br.com.braspag.sdk.core

data class NetworkThrowable(
    override val message: String,
    val statusCode: HttpStatusCode, val parent: Throwable?
) : Throwable(message, parent)