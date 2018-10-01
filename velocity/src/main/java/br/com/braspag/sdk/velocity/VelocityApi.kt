package br.com.braspag.sdk.velocity

import br.com.braspag.sdk.velocity.contracts.AnalysisRequest
import br.com.braspag.sdk.velocity.contracts.AnalysisResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface VelocityApi {

    @POST("analysis/v2/")
    fun performAnalysis(
        @Body model: AnalysisRequest
    ): Call<AnalysisResponse>
}