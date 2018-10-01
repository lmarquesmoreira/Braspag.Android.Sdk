package br.com.braspag.pagador.contracts

import br.com.braspag.pagador.models.CustomerModel
import br.com.braspag.pagador.models.RecurrentPaymentRequestModel
import com.google.gson.annotations.SerializedName

data class RecurrentPaymentResponse(
        @SerializedName("Customer")val customer: CustomerModel,
        @SerializedName("RecurrentPayment")val recurrentPaymentModel: RecurrentPaymentRequestModel
)