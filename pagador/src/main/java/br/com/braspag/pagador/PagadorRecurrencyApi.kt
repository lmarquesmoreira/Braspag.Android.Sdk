package br.com.braspag.pagador

import br.com.braspag.pagador.contracts.PaymentRequestModel
import br.com.braspag.pagador.contracts.RecurrentPaymentResponse
import br.com.braspag.pagador.models.CustomerModel
import br.com.braspag.pagador.models.RecurrencyInterval
import retrofit2.Call
import retrofit2.http.*

interface PagadorRecurrencyApi {

    @GET("v2/recurrentpayment/{id}")
    fun getRecurrency(@Path("id") recurrentPaymentId: String): Call<RecurrentPaymentResponse>

    @PUT("v2/recurrentpayment/{id}/reactivate")
    fun reactivateRecurrency(@Path("id") recurrentPaymentId: String): Call<Void>

    @PUT("v2/recurrentpayment/{id}/deactivate")
    fun deactivateRecurrency(@Path("id") recurrentPaymentId: String): Call<Void>

    @PUT("v2/recurrentpayment/{id}/payment")
    fun changeRecurrencyPayment(@Path("id") recurrentPaymentId: String,
                                @Body paymentRequest: PaymentRequestModel): Call<Void>

    @PUT("v2/recurrentpayment/{id}/nextPaymentDate")
    fun changeRecurrencyNextPaymentDate(@Path("id") recurrentPaymentId: String,
                                        @Body nextPaymentDate: String): Call<Void>

    @PUT("v2/recurrentpayment/{id}/amount")
    fun changeRecurrencyAmount(@Path("id") recurrentPaymentId: String,
                               @Body amount: Long): Call<Void>

    @PUT("v2/recurrentpayment/{id}/recurrencyday")
    fun changeRecurrencyDay(@Path("id") recurrentPaymentId: String,
                            @Body day: Int): Call<Void>

    @PUT("v2/recurrentpayment/{id}/interval")
    fun changeRecurrencyInterval(@Path("id") recurrentPaymentId: String,
                                 @Body interval: RecurrencyInterval): Call<Void>

    @PUT("v2/recurrentpayment/{id}/enddate")
    fun changeRecurrencyEndDate(@Path("id") recurrentPaymentId: String,
                                @Body endDate: String): Call<Void>

    @PUT("v2/recurrentpayment/{id}/customer")
    fun changeRecurrencyCustomer(@Path("id") recurrentPaymentId: String,
                                 @Body customer: CustomerModel): Call<Void>

}