package br.com.braspag.sdk.velocity.models

import com.google.gson.annotations.SerializedName

data class EmailAgeResultModel(
    @SerializedName("EmailExist") val emailExist: String,
    @SerializedName("FirstVerificationDate") val firstVerificationDate: String,
    @SerializedName("Score") val score: Int,
    @SerializedName("ScoreDescription") val scoreDescription: String,
    @SerializedName("ReasonId") val reasonId: String,
    @SerializedName("ReasonDescription") val reasonDescription: String,
    @SerializedName("RiskBandId") val riskBandId: String,
    @SerializedName("RiskBandDescription") val riskBandDescription: String
)