package br.com.braspag.pagador.models

import com.google.gson.annotations.SerializedName

data class CustomerModel(
        @SerializedName("Name") val name: String,
        @SerializedName("Identity") val identity: String,
        @SerializedName("IdentityType") val identityType: String,
        @SerializedName("Email") val email: String? = null,
        @SerializedName("Birthdate") val birthdate: String? = null,
        @SerializedName("Mobile") val mobile: String? = null,
        @SerializedName("Phone") val phone: String? = null,
        @SerializedName("Address") val address: AddressModel,
        @SerializedName("DeliveryAddress") val deliveryAddress: AddressModel
)