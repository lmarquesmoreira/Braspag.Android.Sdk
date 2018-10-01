package br.com.braspag.sdk.velocity.models

import com.google.gson.annotations.SerializedName

data class AnalysisResultModel(
    @SerializedName("Score") val score: Int,
    @SerializedName("Status") val status: String,
    @SerializedName("RejectReasons") val rejectReasons: List<RejectReasonModel>,
    @SerializedName("AcceptByWhiteList") val acceptByWhiteList: Boolean,
    @SerializedName("RejectByBlackList") val rejectByBlackList: Boolean
)