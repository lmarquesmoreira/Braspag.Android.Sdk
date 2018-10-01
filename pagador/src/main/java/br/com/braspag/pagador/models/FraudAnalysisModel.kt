package br.com.braspag.pagador.models

import com.google.gson.annotations.SerializedName

data class FraudAnalysisModel(
        @SerializedName("Sequence") val sequence: String,
        @SerializedName("SequenceCriteria") val sequenceCriteria: String,
        @SerializedName("FingerPrintId") val fingerPrintId: String,
        @SerializedName("Provider") val provider: String,
        @SerializedName("CaptureOnLowRisk") val captureOnLowRisk: Boolean = false,
        @SerializedName("VoidOnHighRisk") val voidOnHighRisk: Boolean = false,
        @SerializedName("TotalOrderAmount") val totalOrderAmount: Long,
        @SerializedName("Browser") val browser: FraudAnalysisBrowserModel? = null,
        @SerializedName("Cart") val cart: FraudAnalysisCartModel? = null,
        @SerializedName("Shipping") val shipping: FraudAnalysisShippingModel? = null,
        @SerializedName("Travel") val travel: FraudAnalysisTravelModel? = null,
        @SerializedName("MerchantDefinedFields") val merchantDefinedFields: List<FraudAnalysisMerchantFieldsModel>? = null
)

data class FraudAnalysisBrowserModel(
        @SerializedName("CookiesAccepted") val cookiesAccepted: Boolean,
        @SerializedName("HostName") val hostName: String,
        @SerializedName("Email") val email: String,
        @SerializedName("Type") val type: String,
        @SerializedName("IpAddress") val ipAddress: String
)

data class FraudAnalysisCartModel(
        @SerializedName("IsGift") val isGift: Boolean = false,
        @SerializedName("ReturnsAccepted") val returnsAccepted: Boolean? = false,
        @SerializedName("Items") val items: List<FraudAnalysisCartItemModel>
)

data class FraudAnalysisCartItemModel(
        @SerializedName("GiftCategory") val giftCategory: String,
        @SerializedName("HostHedge") val hostHedge: String,
        @SerializedName("NonSensicalHedge") val nonSensicalHedge: String,
        @SerializedName("ObscenitiesHedge") val obscenitiesHedge: String,
        @SerializedName("PhoneHedge") val phoneHedge: String,
        @SerializedName("TimeHedge") val timeHedge: String,
        @SerializedName("VelocityHedge") val velocityHedge: String,
        @SerializedName("Name") val name: String,
        @SerializedName("Quantity") val quantity: Int,
        @SerializedName("Sku") val sku: String,
        @SerializedName("UnitPrice") val unitPrice: Long,
        @SerializedName("Risk") val risk: String,
        @SerializedName("Type") val type: String,
        @SerializedName("Passenger") val passenger: FraudAnalysisPassengerModel
)

data class FraudAnalysisPassengerModel(
        @SerializedName("Email") val email: String,
        @SerializedName("Identity") val identity: String,
        @SerializedName("Name") val name: String,
        @SerializedName("Rating") val rating: String,
        @SerializedName("Phone") val phone: String,
        @SerializedName("Status") val status: String,
        @SerializedName("TicketNumber") val ticketNumber: String,
        @SerializedName("FrequentFlyerNumber") val frequentFlyerNumber: String,
        @SerializedName("TravelLegs") val travelLegs: List<FraudAnalysisTravelLegModel>
)

data class FraudAnalysisTravelLegModel(
        @SerializedName("Destination") val destination: String,
        @SerializedName("Origin") val origin: String
)

data class FraudAnalysisShippingModel(
        @SerializedName("Addressee") val addressee: String,
        @SerializedName("Phone") val phone: String,
        @SerializedName("Method") val method: String
)

data class FraudAnalysisTravelModel(
        @SerializedName("JourneyType") val journeyType: String,
        @SerializedName("DepartureDateTime") val departureDateTime: String,
        @SerializedName("Passengers") val passengers: List<FraudAnalysisPassengerModel>
)

data class FraudAnalysisMerchantFieldsModel(
        @SerializedName("Id") val id: String,
        @SerializedName("Value") val value: String
)