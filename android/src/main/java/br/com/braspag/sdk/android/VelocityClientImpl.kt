package br.com.braspag.sdk.android

import br.com.braspag.sdk.core.ApiCredentials
import br.com.braspag.sdk.core.BuildConfig
import br.com.braspag.sdk.core.Environment
import br.com.braspag.sdk.core.network.ApiCredentialsInterceptor
import br.com.braspag.sdk.core.network.ClientResultModel
import br.com.braspag.sdk.core.network.createRequest
import br.com.braspag.sdk.core.network.processRequest
import br.com.braspag.sdk.velocity.VelocityApi
import br.com.braspag.sdk.velocity.contracts.AnalysisRequest
import br.com.braspag.sdk.velocity.contracts.AnalysisResponse

class VelocityClientImpl(private val credentials: ApiCredentials, environment: Environment) :
    VelocityClient {

    private val apiUrl: String = when (environment) {
        Environment.SANDBOX -> BuildConfig.SANDBOX_URL_VELOCITY
        Environment.PRODUCTION -> BuildConfig.PRODUCTION_URL_VELOCITY
    }

    override suspend fun performAnalysis(request: AnalysisRequest): ClientResultModel<AnalysisResponse> {
        return processRequest {
            createRequest(
                apiUrl,
                VelocityApi::class.java,
                listOf(ApiCredentialsInterceptor(credentials))
            ).performAnalysis(request)
                .execute()
        }
    }
}