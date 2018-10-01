package br.com.braspag.pagador.contracts

import br.com.braspag.pagador.models.*
import com.google.gson.annotations.SerializedName

data class SaleResponse(
        @SerializedName("Customer") val customer: CustomerModel,
        @SerializedName("MerchantOrderId") val merchantOrderId: String,
        @SerializedName("Payment") val payment: PaymentResponseModel
)

data class PaymentResponseModel(
        @SerializedName("AcquirerTransactionId") val acquirerTransactionId: String,
        @SerializedName("Amount") val amount: Long,
        @SerializedName("Address") val address: String,
        @SerializedName("AuthenticationUrl") val authenticationUrl: String,
        @SerializedName("Assignor") val assignor: String,
        @SerializedName("AuthorizationCode") val authorizationCode: String,
        @SerializedName("BarCodeNumber") val barcodeNumber: String,
        @SerializedName("BoletoNumber") val boletoNumber: String,
        @SerializedName("CapturedAmount") val capturedAmount: Long? = null,
        @SerializedName("CapturedDate") val capturedDate: String? = null,
        @SerializedName("Country") val country: String,
        @SerializedName("Credentials") val credentials: SaleCredentialsModel,
        @SerializedName("CreditCard") val creditCard: CreditCardModel? = null,
        @SerializedName("Currency") val currency: String,
        @SerializedName("DaysToFine") val daysToFine: Byte? = null,
        @SerializedName("DaysToInterest") val daysToInterest: Byte? = null,
        @SerializedName("DebitCard") val debitCard: DebitCardModel? = null,
        @SerializedName("Demonstrative") val demonstrative: String? = null,
        @SerializedName("DigitableLine") val digitableLine: String? = null,
        @SerializedName("Eci") val eci: String,
        @SerializedName("ExpirationDate") val expirationDate: String,
        @SerializedName("ExternalAuthentication") val externalAuthentication: ExternalAuthenticationModel? = null,
        @SerializedName("ExtraDataCollection") val extraData: List<ExtraDataModel>? = null,
        @SerializedName("FineAmount") val fineAmount: Long? = null,
        @SerializedName("FineRate") val fineRate: Double? = null,
        @SerializedName("FraudAnalysis") val fraudAnalysis: FraudAnalysisModel? = null,
        @SerializedName("Identification") val identification: String,
        @SerializedName("Installments") val installments: Int,
        @SerializedName("Instructions") val instructions: String,
        @SerializedName("Interest") val interest: String,
        @SerializedName("InterestAmount") val interestAmount: Long? = null,
        @SerializedName("InterestRate") val interestRate: Double? = null,
        @SerializedName("Links") val links: List<LinkResponseModel>,
        @SerializedName("PaymentId") val paymentId: String,
        @SerializedName("ProofOfSale") val proofOfSale: String,
        @SerializedName("Provider") val provider: String,
        @SerializedName("ProviderReturnCode") val providerReturnCode: String,
        @SerializedName("ProviderReturnMessage") val providerReturnMessage: String,
        @SerializedName("ReasonCode") val reasonCode: String,
        @SerializedName("ReasonMessage") val reasonMessage: String,
        @SerializedName("ReceivedDate") val receivedDate: String,
        @SerializedName("Recurrent") val recurrent: Boolean? = null,
        @SerializedName("RecurrentPayment") val recurrentPayment: RecurrentPaymentResponseModel,
        @SerializedName("ReturnUrl") val returnUrl: String,
        @SerializedName("ServiceTaxAmount") val serviceTaxAmount: Long,
        @SerializedName("SoftDescriptor") val softDescriptor: String,
        @SerializedName("Status") val status: TransactionStatus,
        @SerializedName("Type") val type: String,
        @SerializedName("Tid") val tid: String,
        @SerializedName("Url") val url: String,
        @SerializedName("Wallet") val wallet: WalletModel

)

data class LinkResponseModel(
        @SerializedName("Method") val method: String,
        @SerializedName("Rel") val rel: String,
        @SerializedName("Href") val href: String
)
