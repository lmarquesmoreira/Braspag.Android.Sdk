package br.com.braspag.sdk.auth

import br.com.braspag.sdk.auth.contracts.AccessTokenRequest
import br.com.braspag.sdk.auth.contracts.AccessTokenResponse
import br.com.braspag.sdk.auth.contracts.OAuthGrantType
import br.com.braspag.sdk.auth.models.AuthorizationCodeModel
import br.com.braspag.sdk.core.*
import br.com.braspag.sdk.core.BuildConfig
import br.com.braspag.sdk.core.Environment.PRODUCTION
import br.com.braspag.sdk.core.Environment.SANDBOX
import br.com.braspag.sdk.core.network.BasicAuthInterceptor
import br.com.braspag.sdk.core.network.ClientResultModel
import br.com.braspag.sdk.core.network.createRequest
import br.com.braspag.sdk.core.network.processRequest

class BraspagAuthClientImpl(environment: Environment) : BraspagAuthClient {

    private val apiUrl: String = when (environment) {
        SANDBOX -> BuildConfig.SANDBOX_URL_BRASPAG_AUTH
        PRODUCTION -> BuildConfig.PRODUCTION_URL_BRASPAG_AUTH
    }

    override suspend fun createAccessToken(
        request: AccessTokenRequest
    ): ClientResultModel<AccessTokenResponse> {

        if (!request.isValid()) {

            return ClientResultModel(
                null,
                (-1).toStatusCode(),
                "Invalid Parameters"
            )
        }
        return when (request.grantType) {
            OAuthGrantType.ClientCredentials -> getClientCredentials(request)
            OAuthGrantType.Password -> getPassword(request)
            OAuthGrantType.AuthorizationCode -> getCode(request)
            OAuthGrantType.RefreshToken -> getRefreshToken(request)
        }
    }

    private fun getClientCredentials(
        request: AccessTokenRequest
    ): ClientResultModel<AccessTokenResponse> =
        processRequest {
            createRequest(
                apiUrl, BraspagAuthApi::class.java, additionalInterceptors = listOf(
                    BasicAuthInterceptor(
                        request.clientId!!,
                        request.clientSecret!!
                    )
                )
            ).getAccessTokenByCredentials(
                scope = request.scope
            ).execute()
        }

    private fun getPassword(
        request: AccessTokenRequest
    ): ClientResultModel<AccessTokenResponse> =
        processRequest {
            createRequest(
                apiUrl, BraspagAuthApi::class.java, additionalInterceptors = listOf(
                    BasicAuthInterceptor(
                        request.clientId!!,
                        request.clientSecret!!
                    )
                )
            ).getAccessTokenByPassword(
                username = request.userName!!,
                password = request.password!!
            ).execute()
        }

    private fun getRefreshToken(
        request: AccessTokenRequest
    ): ClientResultModel<AccessTokenResponse> =
        processRequest {
            createRequest(
                apiUrl, BraspagAuthApi::class.java, additionalInterceptors = listOf(
                    BasicAuthInterceptor(
                        request.clientId!!,
                        request.clientSecret!!
                    )
                )
            ).refreshAccessToken(
                refreshToken = request.refreshToken!!
            ).execute()
        }

    private fun getCode(
        request: AccessTokenRequest
    ): ClientResultModel<AccessTokenResponse> =
        processRequest {
            createRequest(
                apiUrl, BraspagAuthApi::class.java, additionalInterceptors = listOf(
                    BasicAuthInterceptor(
                        request.clientId!!,
                        request.clientSecret!!
                    )
                )
            ).getAuthorizationCodeToken(
                AuthorizationCodeModel(
                    code = request.code!!,
                    callbackUri = request.callbackUri!!
                )
            ).execute()
        }

}