package br.com.braspag.sdk.velocity.models

import com.google.gson.annotations.SerializedName

data class TransactionModel(
    @SerializedName("OrderId") val orderId: String,
    @SerializedName("Id") val id: String,
    @SerializedName("Date") val date: String,
    @SerializedName("Amount") val amount: Long
)