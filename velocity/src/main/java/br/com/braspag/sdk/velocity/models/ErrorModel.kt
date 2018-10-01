package br.com.braspag.sdk.velocity.models

import com.google.gson.annotations.SerializedName

data class ErrorModel(
    @SerializedName("ErrorCode") val errorCode: Int,
    @SerializedName("Message") val message: String,
    @SerializedName("Field") val field: String?
)