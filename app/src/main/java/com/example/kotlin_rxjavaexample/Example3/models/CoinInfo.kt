package com.example.kotlin_rxjavaexample.Example3.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfo (
    @SerializedName("Data")
    @Expose
    val data: List<CoinInfoData>? = null
)