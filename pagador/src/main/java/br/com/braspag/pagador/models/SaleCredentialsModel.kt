package br.com.braspag.pagador.models

import com.google.gson.annotations.SerializedName

data class SaleCredentialsModel(
        @SerializedName("Code") val code: String?,
        @SerializedName("Key") val key: String?,
        @SerializedName("Password") val password: String?,
        @SerializedName("Username") val userName: String?,
        @SerializedName("Signature") val signature: String?,
        @SerializedName("Agency") val agency: String?,
        @SerializedName("Account") val account: String?,
        @SerializedName("Agreement") val agreement: String?,
        @SerializedName("Wallet") val wallet: String?,
        @SerializedName("TransfererCode") val transfererCode: String?
)