package br.com.braspag.pagador.models

import com.google.gson.annotations.SerializedName

data class AddressModel(
        @SerializedName("Street") val street: String,
        @SerializedName("Number") val number: String,
        @SerializedName("Complement") val complement: String,
        @SerializedName("ZipCode") val zipCode: String,
        @SerializedName("District") val district: String,
        @SerializedName("City") val city: String,
        @SerializedName("State") val state: String,
        @SerializedName("Country") val country: String
)
