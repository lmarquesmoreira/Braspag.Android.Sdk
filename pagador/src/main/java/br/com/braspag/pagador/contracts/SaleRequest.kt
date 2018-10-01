package br.com.braspag.pagador.contracts

import br.com.braspag.pagador.models.*
import com.google.gson.annotations.SerializedName

data class SaleRequest(
        @SerializedName("MerchantOrderId") val merchantOrderId: String,
        @SerializedName("Customer") val customer: CustomerModel,
        @SerializedName("Payment") val payment: PaymentRequestModel
)

data class PaymentRequestModel(
        @SerializedName("Type") val type: String,
        @SerializedName("Amount") val amount: Long,
        @SerializedName("Provider") val provider: String,
        @SerializedName("ServiceTaxAmount") val serviceTaxAmount: Long,
        @SerializedName("Capture") val capture: Boolean,
        @SerializedName("Installments") val installments: Int,
        @SerializedName("Interest") val interest: String? = null,
        @SerializedName("Currency") val currency: String,
        @SerializedName("Country") val country: String,
        @SerializedName("Authenticate") val authenticate: Boolean,
        @SerializedName("Recurrent") val recurrent: Boolean = false,
        @SerializedName("SoftDescriptor") val softDescriptor: String,
        @SerializedName("ReturnUrl") val returnUrl: String,
        @SerializedName("BoletoNumber") val boletoNumber: String? = null,
        @SerializedName("Assignor") val assignor: String? = null,
        @SerializedName("Demonstrative") val demonstrative: String,
        @SerializedName("ExpirationDate") val expirationDate: String,
        @SerializedName("Identification") val identification: String,
        @SerializedName("Instructions") val instructions: String,
        @SerializedName("DaysToFine") val daysToFine: Byte? = null,
        @SerializedName("FineRate") val fineRate: Double? = null,
        @SerializedName("FineAmount") val fineAmount: Long? = null,
        @SerializedName("DaysToInterest") val daysToInterest: Byte? = null,
        @SerializedName("InterestRate") val interestDate: Double? = null,
        @SerializedName("InterestAmount") val interestAmount: Long? = null,
        @SerializedName("CreditCard") val creditCard: CreditCardModel? = null,
        @SerializedName("DebitCard") val debitCard: DebitCardModel? = null,
        @SerializedName("Wallet") val wallet: WalletModel? = null,
        @SerializedName("Credentials") val credentials: SaleCredentialsModel? = null,
        @SerializedName("ExternalAuthentication") val externalAuthentication: ExternalAuthenticationModel? = null,
        @SerializedName("FraudAnalysis") val fraudAnalysis: FraudAnalysisModel? = null,
        @SerializedName("RecurrentPayment") val recurrentPayment: RecurrentPaymentRequestModel? = null,
        @SerializedName("ExtraDataCollection") val extraData: List<ExtraDataModel>? = null

)