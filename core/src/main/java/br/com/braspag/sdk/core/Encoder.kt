package br.com.braspag.sdk.core

object Encoder {
    fun encodeToBase64(data: String): String =
        org.apache.commons.codec.binary.Base64.encodeBase64String(data.toByteArray())
}