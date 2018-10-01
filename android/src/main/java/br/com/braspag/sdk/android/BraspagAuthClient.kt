package br.com.braspag.sdk.android

import br.com.braspag.sdk.auth.contracts.AccessTokenRequest
import br.com.braspag.sdk.auth.contracts.AccessTokenResponse
import br.com.braspag.sdk.core.network.ClientResultModel

interface BraspagAuthClient {

    suspend fun createAccessToken(request: AccessTokenRequest) : ClientResultModel<AccessTokenResponse>

}