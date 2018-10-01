package br.com.braspag.sdk.velocity.contracts

import br.com.braspag.sdk.velocity.models.*
import com.google.gson.annotations.SerializedName

data class AnalysisResponse(
    @SerializedName("AnalysisResult") val analysisResult: AnalysisResultModel,
    @SerializedName("Transaction") val transaction: TransactionModel,
    @SerializedName("RequestId") val requestId: String,
    @SerializedName("EmailageResult") val emailageResult: EmailAgeResultModel?,
    @SerializedName("CredilinkResult") val credilinkResult: CrediLinkResultModel?,
    @SerializedName("ErrorDataCollection") val errorDataCollection: List<ErrorModel>?
)