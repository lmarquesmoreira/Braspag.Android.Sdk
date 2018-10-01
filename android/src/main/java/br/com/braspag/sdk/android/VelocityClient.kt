package br.com.braspag.sdk.android

import br.com.braspag.sdk.core.network.ClientResultModel
import br.com.braspag.sdk.velocity.contracts.AnalysisRequest
import br.com.braspag.sdk.velocity.contracts.AnalysisResponse

interface VelocityClient {

    suspend fun performAnalysis(request: AnalysisRequest) : ClientResultModel<AnalysisResponse>
}