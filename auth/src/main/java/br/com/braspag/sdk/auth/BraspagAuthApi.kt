package br.com.braspag.sdk.auth

import br.com.braspag.sdk.auth.contracts.AccessTokenResponse
import br.com.braspag.sdk.auth.models.AuthorizationCodeModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface BraspagAuthApi {

    @FormUrlEncoded
    @POST("oauth2/token")
    fun getAccessTokenByCredentials(
        @Field("scope") scope: String? = null,
        @Field("grant_type") grantType: String = "client_credentials"
    ): Call<AccessTokenResponse>

    @FormUrlEncoded
    @POST("oauth2/token")
    fun getAccessTokenByPassword(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("scope") scope: String? = null,
        @Field("grant_type") grantType: String = "password"
    ): Call<AccessTokenResponse>

    @FormUrlEncoded
    @POST("oauth2/token")
    fun refreshAccessToken(
        @Field("refresh_token") refreshToken: String,
        @Field("grant_type") grantType: String = "refresh_token"
    ): Call<AccessTokenResponse>

    // TODO Verificar se existe mesmo esse endpoint
    @POST("oauth2/token")
    fun getAuthorizationCodeToken(
        @Body model: AuthorizationCodeModel
    ): Call<AccessTokenResponse>

}