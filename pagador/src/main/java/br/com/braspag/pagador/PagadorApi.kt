package br.com.braspag.pagador

import br.com.braspag.pagador.contracts.SaleOrderResponse
import br.com.braspag.pagador.contracts.SaleResponse
import br.com.braspag.pagador.contracts.VoidResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface PagadorApi : PagadorRecurrencyApi {

    @GET("v2/sales/")
    fun getSaleByOrderId(@Query("merchantOrderId") id: String): Call<SaleOrderResponse>

    @GET("v2/sales/{id}")
    fun getSaleByPaymentId(@Path("id") paymentId: String): Call<SaleResponse>

    @PUT("v2/sales/{id}/void")
    fun cancelSale(@Path("id") paymentId: String, @Query("amount") amount: Long): Call<VoidResponse>

}