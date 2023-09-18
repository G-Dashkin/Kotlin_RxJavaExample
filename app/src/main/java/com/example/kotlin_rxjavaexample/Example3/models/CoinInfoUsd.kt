package com.example.kotlin_rxjavaexample.Example3.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfoUsd (
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromSymbol: String?,

    @SerializedName("TOSYMBOL")
    @Expose
    val toSymbol: String?,

    @SerializedName("PRICE")
    @Expose
    val price: Float?,

    @SerializedName("LASTUPDATE")
    @Expose
    val lastUpdate: Float?
)