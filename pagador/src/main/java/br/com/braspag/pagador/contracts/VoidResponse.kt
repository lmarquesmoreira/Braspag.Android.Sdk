package br.com.braspag.pagador.contracts

import br.com.braspag.pagador.models.TransactionStatus
import com.google.gson.annotations.SerializedName

data class VoidResponse(
        @SerializedName("ProviderReturnCode")val providerReturnCode: String,
        @SerializedName("ProviderReturnMessage")val providerReturnMessage: String,
        @SerializedName("ReasonCode")val reasonCode: String,
        @SerializedName("ReasonMessage")val reasonMessage: String,
        @SerializedName("Status")val status: TransactionStatus
)