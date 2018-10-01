package br.com.braspag.pagador.contracts

import com.google.gson.annotations.SerializedName

data class SaleOrderResponse(
        @SerializedName("Payments") val payments: List<SaleOrderPaymentModel>
)

data class SaleOrderPaymentModel(
        @SerializedName("PaymentId") val paymentId: String,
        @SerializedName("ReceivedDate") val receivedDate: String
)