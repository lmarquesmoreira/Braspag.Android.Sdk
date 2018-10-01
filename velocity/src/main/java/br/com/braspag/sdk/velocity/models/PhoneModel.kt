package br.com.braspag.sdk.velocity.models

import com.google.gson.annotations.SerializedName

data class PhoneModel(
    @SerializedName("Type") val type: PhoneType,
    @SerializedName("DDI") val ddi: String,
    @SerializedName("DDD") val ddd: String,
    @SerializedName("Number") val number: String,
    @SerializedName("Extension") val extension: String
)

enum class PhoneType(val ref: String) {
    Phone("Phone"),
    Workhone("Workphone"),
    CellPhone("Cellphone")
}