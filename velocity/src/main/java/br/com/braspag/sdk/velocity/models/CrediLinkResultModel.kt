package br.com.braspag.sdk.velocity.models

import com.google.gson.annotations.SerializedName

data class CrediLinkResultModel(
    @SerializedName("IdentityIsValid") val identityIsValid: String,
    @SerializedName("Status") val status: String
)