package br.com.braspag.pagador.models

import com.google.gson.annotations.SerializedName

data class ExternalAuthenticationModel(
        @SerializedName("Cavv")val cavv: String,
        @SerializedName("Xid")val xid: String,
        @SerializedName("Eci")val eci: String
)