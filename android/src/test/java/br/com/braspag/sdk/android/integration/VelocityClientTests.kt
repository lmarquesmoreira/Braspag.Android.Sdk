package br.com.braspag.sdk.android.integration

import br.com.braspag.sdk.android.BraspagAuthClientImpl
import br.com.braspag.sdk.android.VelocityClientImpl
import br.com.braspag.sdk.auth.contracts.AccessTokenRequest
import br.com.braspag.sdk.auth.contracts.OAuthGrantType
import br.com.braspag.sdk.core.ApiCredentials
import br.com.braspag.sdk.core.Environment
import br.com.braspag.sdk.core.http.HttpStatusCode
import br.com.braspag.sdk.velocity.contracts.AnalysisRequest
import br.com.braspag.sdk.velocity.models.*
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Assert
import org.junit.Assert.assertNotNull
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

class VelocityClientTests {

    private fun createAnalysisRequest() = AnalysisRequest(
            transaction = TransactionModel(
                    orderId = "01",
                    id = UUID.randomUUID().toString(),
                    amount = 1000,
                    date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
                            .format(Calendar.getInstance().time).toString()
            ),
            card = CardModel(
                    holder = "BJORN IRONSIDE",
                    brand = "visa",
                    number = "1000100010001000",
                    expiration = "10/2025"
            ),
            customer = CustomerModel(
                    name = "BJORN IRONSIDE",
                    identity = "76250252096",
                    ipAddress = "127.0.0.1",
                    email = "bjorn.ironside@vikings.com.br",
                    birthDate = "1982-06-30",
                    phones = listOf(
                            PhoneModel(
                                    type = PhoneType.CellPhone,
                                    number = "999999999",
                                    ddi = "55",
                                    ddd = "11",
                                    extension = ""
                            )
                    ),
                    billing = AddressModel(
                            street = "Alameda Xingu",
                            number = "512",
                            neighborhood = "Alphaville",
                            city = "Barueri",
                            state = "SP",
                            country = "BR",
                            zipCode = "06455-030"
                    ),
                    shipping = AddressModel(
                            street = "Alameda Xingu",
                            number = "512",
                            neighborhood = "Alphaville",
                            city = "Barueri",
                            state = "SP",
                            country = "BR",
                            zipCode = "06455-030"
                    )
            )
    )

    //@Test
    fun performAnalysis() = runBlocking {

        val client = BraspagAuthClientImpl(Environment.SANDBOX)

        val model = client.createAccessToken(
                AccessTokenRequest(
                        clientId = "5d85902e-592a-44a9-80bb-bdda74d51bce",
                        clientSecret = "mddRzd6FqXujNLygC/KxOfhOiVhlUr2kjKPsOoYHwhQ=",
                        scope = "VelocityApp",
                        grantType = OAuthGrantType.ClientCredentials
                )
        )

        Assert.assertNotNull(model.result)
        Assert.assertEquals(model.statusCode, HttpStatusCode.Ok)
        Assert.assertNotNull(model.result?.token)

        val analysisRequest = createAnalysisRequest()

        val velocityClient = VelocityClientImpl(
                ApiCredentials(
                        merchantId = "94E5EA52-79B0-7DBA-1867-BE7B081EDD97",
                        accessToken = model.result?.token!!
                ), Environment.SANDBOX
        )

        val analysisResponse = velocityClient.performAnalysis(analysisRequest)

        assertNotNull(analysisResponse.result)
    }
}

