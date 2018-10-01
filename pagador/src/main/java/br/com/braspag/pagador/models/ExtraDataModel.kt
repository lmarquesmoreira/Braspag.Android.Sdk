package br.com.braspag.pagador.models

import com.google.gson.annotations.SerializedName

data class ExtraDataModel(
        @SerializedName("Name") val name: String,
        @SerializedName("Value") val value: String
)