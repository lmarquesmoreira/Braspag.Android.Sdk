package br.com.braspag.pagador

import br.com.braspag.pagador.contracts.*
import retrofit2.Call
import retrofit2.http.*

interface PagadorApi : PagadorRecurrencyApi {

    @POST("v2/sales/")
    fun createSale(@Body model: SaleRequest): Call<SaleResponse>

    @GET("v2/sales/")
    fun getSaleByOrderId(@Query("merchantOrderId") id: String): Call<SaleOrderResponse>

    @GET("v2/sales/{id}")
    fun getSaleByPaymentId(@Path("id") paymentId: String): Call<SaleResponse>

    @PUT("v2/sales/{id}/void")
    fun cancelSale(@Path("id") paymentId: String, @Query("amount") amount: Long): Call<VoidResponse>

    @PUT("v2/sales/{id}/capture")
    fun captureSale(@Path("id") paymentId: String, @Query("amount") amount: Long,
                    @Query("serviceTaxAmount") serviceTaxAmount: Long?): Call<CaptureResponse>
}