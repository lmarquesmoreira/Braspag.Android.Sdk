package br.com.braspag.pagador.models

import com.google.gson.annotations.SerializedName

data class RecurrentPaymentModel(
        @SerializedName("Installments") val installments: Int,
        @SerializedName("RecurrentPaymentId") val recurrentPaymentId: String,
        @SerializedName("NextRecurrency") val nextRecurrency: String,
        @SerializedName("StartDate") val startDate: String? = null,
        @SerializedName("EndDate") val endDate: String,
        @SerializedName("Interval") val interval: String,
        @SerializedName("Amount") val amount: Long,
        @SerializedName("Country") val country: String,
        @SerializedName("CreateDate") val createDate: String,
        @SerializedName("Currency") val currency: String,
        @SerializedName("CurrentRecurrencyTry") val currentRecurrencyTry: Int,
        @SerializedName("OrderNumber") val orderNumber: String,
        @SerializedName("Provider") val provider: String,
        @SerializedName("RecurrencyDay") val recurrencyDay: Int,
        @SerializedName("SuccessfulRecurrences") val successfulRecurrences: Int,
        @SerializedName("Status") val status: Int,
        @SerializedName("RecurrentTransactions") val recurrentTransactions: List<RecurrentTransactionModel>
)

data class RecurrentPaymentRequestModel(
        @SerializedName("StartDate") val startDate: String? = null,
        @SerializedName("EndDate") val endDate: String,
        @SerializedName("Interval") val interval: String,
        @SerializedName("AuthorizeNow") val authorizeNow: Boolean = false
)

data class RecurrentPaymentResponseModel(
        @SerializedName("RecurrentPaymentId") val recurrentPaymentId: String,
        @SerializedName("StartDate") val startDate: String? = null,
        @SerializedName("EndDate") val endDate: String,
        @SerializedName("NextRecurrency") val nextRecurrency: String,
        @SerializedName("Interval") val interval: String,
        @SerializedName("AuthorizeNow") val authorizeNow: Boolean? = null,
        @SerializedName("ReasonCode") val reasonCode: Int? = null,
        @SerializedName("ReasonMessage") val reasonMessage: String? = null
)

data class RecurrentTransactionModel(
        @SerializedName("PaymentNumber") val paymentNumber: Int,
        @SerializedName("RecurrentPaymentId") val recurrentPaymentId: String,
        @SerializedName("TransactionId") val transactionId: String,
        @SerializedName("TryNumber") val tryNumber: Int

)