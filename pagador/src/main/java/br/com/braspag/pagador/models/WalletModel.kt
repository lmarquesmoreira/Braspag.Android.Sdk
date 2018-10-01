package br.com.braspag.pagador.models

import com.google.gson.annotations.SerializedName

data class WalletModel(
        @SerializedName("Type") val type: String,
        @SerializedName("WalletKey") val walletKey: String,
        @SerializedName("AdditionalData") val additionalData: AdditionalDataModel
)

data class AdditionalDataModel(@SerializedName("EphemeralPublicKey") val ephemeralPublicKey: String)

