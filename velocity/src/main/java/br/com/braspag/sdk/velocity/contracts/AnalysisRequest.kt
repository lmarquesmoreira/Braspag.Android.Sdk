package br.com.braspag.sdk.velocity.contracts

import br.com.braspag.sdk.velocity.models.CardModel
import br.com.braspag.sdk.velocity.models.CustomerModel
import br.com.braspag.sdk.velocity.models.TransactionModel
import com.google.gson.annotations.SerializedName

data class AnalysisRequest(
    @SerializedName("Transaction") val transaction: TransactionModel,
    @SerializedName("Card") val card: CardModel,
    @SerializedName("Customer") val customer: CustomerModel
)