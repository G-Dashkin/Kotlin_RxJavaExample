package com.example.kotlin_rxjavaexample.Example3.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfoRaw (
    @SerializedName("USD")
    @Expose
    val usd: CoinInfoUsd
)