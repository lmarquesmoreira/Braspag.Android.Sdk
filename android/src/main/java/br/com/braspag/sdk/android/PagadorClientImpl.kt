package br.com.braspag.sdk.android

import br.com.braspag.pagador.PagadorApi
import br.com.braspag.pagador.contracts.*
import br.com.braspag.pagador.models.CustomerModel
import br.com.braspag.pagador.models.RecurrencyInterval
import br.com.braspag.sdk.core.ApiCredentials
import br.com.braspag.sdk.core.BuildConfig
import br.com.braspag.sdk.core.Environment
import br.com.braspag.sdk.core.network.*

class PagadorClientImpl(private val credentials: ApiCredentials, environment: Environment) : PagadorClient {

    private val apiUrl: String = when (environment) {
        Environment.SANDBOX -> BuildConfig.SANDBOX_URL_PAGADOR
        Environment.PRODUCTION -> BuildConfig.PRODUCTION_URL_PAGADOR
    }

    private val apiQueryUrl: String = when (environment) {
        Environment.SANDBOX -> BuildConfig.SANDBOX_URL_PAGADOR_QUERY
        Environment.PRODUCTION -> BuildConfig.PRODUCTION_URL_PAGADOR_QUERY
    }

    override suspend fun reactivateRecurrency(recurrentPaymentId: String): ClientResultModel<Boolean> {
        return processRequestForVoidResponse {
            createRequest(
                    apiUrl,
                    PagadorApi::class.java,
                    listOf(ApiCredentialsInterceptor(credentials))
            ).reactivateRecurrency(recurrentPaymentId)
                    .execute()
        }
    }

    override suspend fun deactivateRecurrency(recurrentPaymentId: String): ClientResultModel<Boolean> {
        return processRequestForVoidResponse {
            createRequest(
                    apiUrl,
                    PagadorApi::class.java,
                    listOf(ApiCredentialsInterceptor(credentials))
            ).deactivateRecurrency(recurrentPaymentId)
                    .execute()
        }
    }

    override suspend fun changeRecurrencyPayment(recurrentPaymentId: String, paymentRequest: PaymentRequestModel): ClientResultModel<Boolean> {
        return processRequestForVoidResponse {
            createRequest(
                    apiUrl,
                    PagadorApi::class.java,
                    listOf(ApiCredentialsInterceptor(credentials))
            ).changeRecurrencyPayment(recurrentPaymentId, paymentRequest)
                    .execute()
        }
    }

    override suspend fun changeRecurrencyNextPaymentDate(recurrentPaymentId: String, nextPaymentDate: String): ClientResultModel<Boolean> {
        return processRequestForVoidResponse {
            createRequest(
                    apiUrl,
                    PagadorApi::class.java,
                    listOf(ApiCredentialsInterceptor(credentials))
            ).changeRecurrencyNextPaymentDate(recurrentPaymentId, nextPaymentDate)
                    .execute()
        }
    }

    override suspend fun changeRecurrencyAmount(recurrentPaymentId: String, amount: Long): ClientResultModel<Boolean> {
        return processRequestForVoidResponse {
            createRequest(
                    apiUrl,
                    PagadorApi::class.java,
                    listOf(ApiCredentialsInterceptor(credentials))
            ).changeRecurrencyAmount(recurrentPaymentId, amount)
                    .execute()
        }
    }

    override suspend fun changeRecurrencyDay(recurrentPaymentId: String, day: Int): ClientResultModel<Boolean> {
        return processRequestForVoidResponse {
            createRequest(
                    apiUrl,
                    PagadorApi::class.java,
                    listOf(ApiCredentialsInterceptor(credentials))
            ).changeRecurrencyDay(recurrentPaymentId, day)
                    .execute()
        }
    }

    override suspend fun changeRecurrencyInterval(recurrentPaymentId: String, interval: RecurrencyInterval): ClientResultModel<Boolean> {
        return processRequestForVoidResponse {
            createRequest(
                    apiUrl,
                    PagadorApi::class.java,
                    listOf(ApiCredentialsInterceptor(credentials))
            ).changeRecurrencyInterval(recurrentPaymentId, interval)
                    .execute()
        }
    }

    override suspend fun changeRecurrencyEndDate(recurrentPaymentId: String, endDate: String): ClientResultModel<Boolean> {
        return processRequestForVoidResponse {
            createRequest(
                    apiUrl,
                    PagadorApi::class.java,
                    listOf(ApiCredentialsInterceptor(credentials))
            ).changeRecurrencyEndDate(recurrentPaymentId, endDate)
                    .execute()
        }
    }

    override suspend fun changeRecurrencyCustomer(recurrentPaymentId: String, customer: CustomerModel): ClientResultModel<Boolean> {
        return processRequestForVoidResponse {
            createRequest(
                    apiUrl,
                    PagadorApi::class.java,
                    listOf(ApiCredentialsInterceptor(credentials))
            ).changeRecurrencyCustomer(recurrentPaymentId, customer)
                    .execute()
        }
    }

    override suspend fun getRecurrency(recurrentPaymentId: String): ClientResultModel<RecurrentPaymentResponse> {
        return processRequest {
            createRequest(
                    apiQueryUrl,
                    PagadorApi::class.java,
                    listOf(ApiCredentialsInterceptor(credentials))
            ).getRecurrency(recurrentPaymentId)
                    .execute()
        }
    }

    override suspend fun createSale(model: SaleRequest): ClientResultModel<SaleResponse> {
        return processRequest {
            createRequest(
                    apiUrl,
                    PagadorApi::class.java,
                    listOf(ApiCredentialsInterceptor(credentials))
            ).createSale(model)
                    .execute()
        }
    }

    override suspend fun getSaleByOrderId(id: String): ClientResultModel<SaleOrderResponse> {
        return processRequest {
            createRequest(
                    apiQueryUrl,
                    PagadorApi::class.java,
                    listOf(ApiCredentialsInterceptor(credentials))
            ).getSaleByOrderId(id)
                    .execute()
        }
    }

    override suspend fun getSaleByPaymentId(paymentId: String): ClientResultModel<SaleResponse> {
        return processRequest {
            createRequest(
                    apiQueryUrl,
                    PagadorApi::class.java,
                    listOf(ApiCredentialsInterceptor(credentials))
            ).getSaleByPaymentId(paymentId)
                    .execute()
        }
    }

    override suspend fun cancelSale(paymentId: String, amount: Long): ClientResultModel<VoidResponse> {
        return processRequest {
            createRequest(
                    apiUrl,
                    PagadorApi::class.java,
                    listOf(ApiCredentialsInterceptor(credentials))
            ).cancelSale(paymentId, amount)
                    .execute()
        }
    }

    override suspend fun captureSale(paymentId: String, amount: Long, serviceTaxAmount: Long?): ClientResultModel<CaptureResponse> {
        return processRequest {
            createRequest(
                    apiUrl,
                    PagadorApi::class.java,
                    listOf(ApiCredentialsInterceptor(credentials))
            ).captureSale(paymentId, amount, serviceTaxAmount)
                    .execute()
        }
    }

}