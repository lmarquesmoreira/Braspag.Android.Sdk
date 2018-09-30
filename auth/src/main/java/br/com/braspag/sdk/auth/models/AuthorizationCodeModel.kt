package br.com.braspag.sdk.auth.models

import com.google.gson.annotations.SerializedName

data class AuthorizationCodeModel(
    @SerializedName("redirect_uri") val callbackUri: String,
    @SerializedName("code") val code: String,
    @SerializedName("grant_type") val grantType: String = "authorization_code"
)