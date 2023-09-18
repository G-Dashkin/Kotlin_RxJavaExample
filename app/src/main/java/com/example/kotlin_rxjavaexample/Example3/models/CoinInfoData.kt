package com.example.kotlin_rxjavaexample.Example3.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfoData (
    @SerializedName("CoinInfo")
    @Expose
    val coinInfo: CoinPriceInfo,

    @SerializedName("RAW")
    @Expose
    val raw: CoinInfoRaw
)