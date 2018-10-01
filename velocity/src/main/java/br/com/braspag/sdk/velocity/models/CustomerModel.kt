package br.com.braspag.sdk.velocity.models

import com.google.gson.annotations.SerializedName

data class CustomerModel(
    @SerializedName("Name") val name: String,
    @SerializedName("Identity") val identity: String,
    @SerializedName("IpAddress") val ipAddress: String,
    @SerializedName("BirthDate") val birthDate: String,
    @SerializedName("Email") val email: String,
    @SerializedName("Phones") val phones: List<PhoneModel>,
    @SerializedName("Billing") val billing: AddressModel,
    @SerializedName("Shipping") val shipping: AddressModel
)