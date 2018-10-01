package br.com.braspag.sdk.velocity.models

import com.google.gson.annotations.SerializedName

data class CardModel(
    @SerializedName("Holder") val holder: String,
    @SerializedName("Number") val number: String,
    @SerializedName("Expiration") val expiration: String,
    @SerializedName("Brand") val brand: String
)
