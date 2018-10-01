package br.com.braspag.pagador.contracts

import com.google.gson.annotations.SerializedName

data class CaptureRequest(
        @SerializedName("Amount") val amount: Long,
        @SerializedName("ServiceTaxAmount") val serviceTaxAmount: Long? = null,
        @SerializedName("PaymentId") val paymentId: String
)