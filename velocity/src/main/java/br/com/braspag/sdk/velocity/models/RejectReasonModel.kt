package br.com.braspag.sdk.velocity.models

import com.google.gson.annotations.SerializedName

data class RejectReasonModel(
    @SerializedName("RuleId") val ruleId: Int,
    @SerializedName("Message") val message: String
)