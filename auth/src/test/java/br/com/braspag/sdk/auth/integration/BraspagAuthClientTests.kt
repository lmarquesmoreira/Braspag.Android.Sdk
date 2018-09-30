package br.com.braspag.sdk.auth.integration

import br.com.braspag.sdk.auth.BraspagAuthClientImpl
import br.com.braspag.sdk.auth.contracts.AccessTokenRequest
import br.com.braspag.sdk.auth.contracts.OAuthGrantType
import br.com.braspag.sdk.core.Environment
import br.com.braspag.sdk.core.http.HttpStatusCode
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Assert.*
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
        assertNull(model.result)
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

        assertNotNull(model.result)
        assertEquals(model.statusCode, HttpStatusCode.Ok)
        assertNotNull(model.result?.token)
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

        assertNotNull(model.result)
        assertEquals(model.statusCode, HttpStatusCode.Ok)
        assertNotNull(model.result?.token)
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
        assertNull(model.result)
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

        assertNotNull(model.result)
        assertEquals(model.statusCode, HttpStatusCode.Ok)
        assertNotNull(model.result?.token)


        val refreshTokenModel = client.createAccessToken(
            AccessTokenRequest(
                clientId = "b7554867-c69a-4fd2-b059-40c08f6f924a",
                clientSecret = "9tV4mICf6YmKiRkfPce8+jHc4M2hLGgBdMCxnlj3LDY=",
                refreshToken = model.result?.refreshToken,
                grantType = OAuthGrantType.RefreshToken
            )
        )

        assertNull(refreshTokenModel.result)
    }

}