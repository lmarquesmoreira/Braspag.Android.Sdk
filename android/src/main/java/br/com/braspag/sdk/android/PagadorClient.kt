package br.com.braspag.sdk.android

import br.com.braspag.pagador.contracts.PaymentRequestModel
import br.com.braspag.pagador.contracts.RecurrentPaymentResponse
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

}