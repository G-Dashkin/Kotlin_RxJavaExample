package com.example.kotlin_rxjavaexample.Example3

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Datum (
    @SerializedName("CoinInfo")
    @Expose
    val coinInfo: List<CoinPriceInfo>
)