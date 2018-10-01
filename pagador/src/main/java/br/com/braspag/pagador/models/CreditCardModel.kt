package br.com.braspag.pagador.models

import com.google.gson.annotations.SerializedName


data class DebitCardModel(
        @SerializedName("CardNumber") val cardNumber: String,
        @SerializedName("Holder") val holder: String,
        @SerializedName("ExpirationDate") val expirationDate: String,
        @SerializedName("Brand") val brand: String,
        @SerializedName("SecurityCode") val securityCode: String,
        @SerializedName("SaveCard") val saveCard: Boolean = false
)

data class CreditCardModel(
        @SerializedName("CardToken") val cardToken: String,
        @SerializedName("CardNumber") val cardNumber: String,
        @SerializedName("Holder") val holder: String,
        @SerializedName("ExpirationDate") val expirationDate: String,
        @SerializedName("SecurityCode") val securityCode: String,
        @SerializedName("PaymentToken") val paymentToken: String,
        @SerializedName("Brand") val brand: String,
        @SerializedName("SaveCard") val saveCard: Boolean = false,
        @SerializedName("Alias") val alias: String? = null,
        @SerializedName("Avs") val avs: AvsModel
)

data class AvsModel(
        @SerializedName("Cpf") val cpf: String,
        @SerializedName("ZipCode") val zipCode: String,
        @SerializedName("Street") val street: String,
        @SerializedName("Number") val number: String,
        @SerializedName("Complement") val complement: String,
        @SerializedName("District") val district: String,
        @SerializedName("Status") val status: Int? = null,
        @SerializedName("ReturnCode") val returnCode: String? = null
)