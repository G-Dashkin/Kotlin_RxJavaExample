package com.example.kotlin_rxjavaexample.Example3

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfoListOfData (
    @SerializedName("Type")
    @Expose
    val type: Int
)