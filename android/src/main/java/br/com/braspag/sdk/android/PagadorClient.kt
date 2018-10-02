package br.com.braspag.sdk.android

import br.com.braspag.pagador.contracts.*
import br.com.braspag.pagador.models.CustomerModel
import br.com.braspag.pagador.models.RecurrencyInterval
import br.com.braspag.sdk.core.network.ClientResultModel

interface PagadorClient {

    suspend fun getRecurrency(recurrentPaymentId: String): ClientResultModel<RecurrentPaymentResponse>

    suspend fun reactivateRecurrency(recurrentPaymentId: String): ClientResultModel<Boolean>

    suspend fun deactivateRecurrency(recurrentPaymentId: String): ClientResultModel<Boolean>

    suspend fun changeRecurrencyPayment(recurrentPaymentId: String, paymentRequest: PaymentRequestModel): ClientResultModel<Boolean>

    suspend fun changeRecurrencyNextPaymentDate(recurrentPaymentId: String, nextPaymentDate: String): ClientResultModel<Boolean>

    suspend fun changeRecurrencyAmount(recurrentPaymentId: String, amount: Long): ClientResultModel<Boolean>

    suspend fun changeRecurrencyDay(recurrentPaymentId: String, day: Int): ClientResultModel<Boolean>

    suspend fun changeRecurrencyInterval(recurrentPaymentId: String, interval: RecurrencyInterval): ClientResultModel<Boolean>

    suspend fun changeRecurrencyEndDate(recurrentPaymentId: String, endDate: String): ClientResultModel<Boolean>

    suspend fun changeRecurrencyCustomer(recurrentPaymentId: String, customer: CustomerModel): ClientResultModel<Boolean>

    suspend fun createSale(model: SaleRequest): ClientResultModel<SaleResponse>

    suspend fun getSaleByOrderId(id: String): ClientResultModel<SaleOrderResponse>

    suspend fun getSaleByPaymentId(paymentId: String): ClientResultModel<SaleResponse>

    suspend fun cancelSale(paymentId: String, amount: Long): ClientResultModel<VoidResponse>

    suspend fun captureSale(paymentId: String, amount: Long,
                            serviceTaxAmount: Long?): ClientResultModel<CaptureResponse>

}