package br.com.braspag.sdk.auth.contracts

import br.com.braspag.sdk.auth.contracts.OAuthGrantType.*
import com.google.gson.annotations.SerializedName

// TODO need Refactoring
data class AccessTokenRequest(
    val grantType: OAuthGrantType,
    val clientId: String? = null,
    val clientSecret: String? = null,
    val scope: String? = null,
    val refreshToken: String? = null,
    val userName: String? = null,
    val password: String? = null,
    val code: String? = null,
    val callbackUri: String? = null
) {

    fun isValid(): Boolean {
        if (!credentialsIsValid())
            return false

        return when (grantType) {
            ClientCredentials -> true
            Password -> passwordIsValid()
            RefreshToken -> refreshTokenIsValid()
            AuthorizationCode -> authorizationCodeIsValid()
        }
    }

    fun scopeIsValid(): Boolean {
        if (!scope.isNullOrBlank())
            return true
        return false
    }

    private fun authorizationCodeIsValid(): Boolean {
        if (!code.isNullOrBlank() && !callbackUri.isNullOrBlank())
            return true
        return false
    }

    private fun credentialsIsValid(): Boolean {
        if (!clientId.isNullOrBlank() && !clientSecret.isNullOrBlank())
            return true
        return false
    }

    private fun passwordIsValid(): Boolean {
        if (!userName.isNullOrBlank() && !password.isNullOrBlank())
            return true
        return false
    }

    private fun refreshTokenIsValid(): Boolean {
        if (!refreshToken.isNullOrBlank())
            return true
        return false
    }

}
