package br.com.braspag.sdk.android.integration

import br.com.braspag.sdk.android.BraspagAuthClientImpl
import br.com.braspag.sdk.auth.contracts.AccessTokenRequest
import br.com.braspag.sdk.auth.contracts.OAuthGrantType
import br.com.braspag.sdk.core.Environment
import br.com.braspag.sdk.core.http.HttpStatusCode
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Assert
import org.junit.Test

class BraspagAuthClientTests {

    @Test
    fun createAccessTokenWithoutParameters() = runBlocking {
        val client = BraspagAuthClientImpl(Environment.SANDBOX)
        val model = client.createAccessToken(
                AccessTokenRequest(
                        grantType = OAuthGrantType.ClientCredentials
                )
        )
        Assert.assertNull(model.result)
    }

    @Test
    fun createAccessTokenWithClientCredentials() = runBlocking {

        val client = BraspagAuthClientImpl(Environment.SANDBOX)

        val model = client.createAccessToken(
                AccessTokenRequest(
                        clientId = "b7554867-c69a-4fd2-b059-40c08f6f924a",
                        clientSecret = "9tV4mICf6YmKiRkfPce8+jHc4M2hLGgBdMCxnlj3LDY=",
                        grantType = OAuthGrantType.ClientCredentials
                )
        )

        Assert.assertNotNull(model.result)
        Assert.assertEquals(model.statusCode, HttpStatusCode.Ok)
        Assert.assertNotNull(model.result?.token)
    }

    //@Test
    fun createAccessTokenWithPassword() = runBlocking {

        val client = BraspagAuthClientImpl(Environment.SANDBOX)

        val model = client.createAccessToken(
                AccessTokenRequest(
                        clientId = "b7554867-c69a-4fd2-b059-40c08f6f924a",
                        clientSecret = "9tV4mICf6YmKiRkfPce8+jHc4M2hLGgBdMCxnlj3LDY=",
                        userName = "<username>",
                        password = "<password>",
                        grantType = OAuthGrantType.Password
                )
        )

        Assert.assertNotNull(model.result)
        Assert.assertEquals(model.statusCode, HttpStatusCode.Ok)
        Assert.assertNotNull(model.result?.token)
    }

    @Test
    fun createAccessTokenWithAuthorizationCode() = runBlocking {

        val client = BraspagAuthClientImpl(Environment.SANDBOX)

        val model = client.createAccessToken(
                AccessTokenRequest(
                        clientId = "b7554867-c69a-4fd2-b059-40c08f6f924a",
                        clientSecret = "9tV4mICf6YmKiRkfPce8+jHc4M2hLGgBdMCxnlj3LDY=",
                        code = "00001",
                        callbackUri = "https://minhaurl.com",
                        grantType = OAuthGrantType.AuthorizationCode
                )
        )

        println(model.messageError)
        Assert.assertNull(model.result)
    }

    @Test
    fun createAccessTokenWithRefreshToken() = runBlocking {

        val client = BraspagAuthClientImpl(Environment.SANDBOX)

        val model = client.createAccessToken(
                AccessTokenRequest(
                        clientId = "b7554867-c69a-4fd2-b059-40c08f6f924a",
                        clientSecret = "9tV4mICf6YmKiRkfPce8+jHc4M2hLGgBdMCxnlj3LDY=",
                        grantType = OAuthGrantType.ClientCredentials
                )
        )

        Assert.assertNotNull(model.result)
        Assert.assertEquals(model.statusCode, HttpStatusCode.Ok)
        Assert.assertNotNull(model.result?.token)


        val refreshTokenModel = client.createAccessToken(
                AccessTokenRequest(
                        clientId = "b7554867-c69a-4fd2-b059-40c08f6f924a",
                        clientSecret = "9tV4mICf6YmKiRkfPce8+jHc4M2hLGgBdMCxnlj3LDY=",
                        refreshToken = model.result?.refreshToken,
                        grantType = OAuthGrantType.RefreshToken
                )
        )

        Assert.assertNull(refreshTokenModel.result)
    }

}