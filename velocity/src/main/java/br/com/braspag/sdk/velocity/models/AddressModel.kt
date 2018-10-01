package br.com.braspag.sdk.velocity.models

import com.google.gson.annotations.SerializedName

data class AddressModel(
    @SerializedName("Street") val street: String,
    @SerializedName("Number") val number: String,
    @SerializedName("Complement") val complement: String? = null,
    @SerializedName("ZipCode") val zipCode: String,
    @SerializedName("Neighborhood") val neighborhood: String,
    @SerializedName("City") val city: String,
    @SerializedName("State") val state: String,
    @SerializedName("Country") val country: String
)