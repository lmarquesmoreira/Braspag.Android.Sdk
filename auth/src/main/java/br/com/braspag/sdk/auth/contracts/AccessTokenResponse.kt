package br.com.braspag.sdk.auth.contracts

import com.google.gson.annotations.SerializedName

data class AccessTokenResponse(
    @SerializedName("access_token") val token: String?,
    @SerializedName("refresh_token") val refreshToken: String?,
    @SerializedName("expires_in") val expiresIn: Int?,
    @SerializedName("error") val error: String?,
    @SerializedName("error_description") val errorDescription: String?
)