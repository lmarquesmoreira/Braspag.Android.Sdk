package br.com.braspag.pagador.contracts

import com.google.gson.annotations.SerializedName

data class VoidRequest(
        @SerializedName("Amount") val amount: Long,
        @SerializedName("PaymentId") val paymentId: String
)