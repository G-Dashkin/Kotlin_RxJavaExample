package com.example.kotlin_rxjavaexample.Example3.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinPriceInfo(
    @SerializedName("Id")
    @Expose
    val id: String?,

    @SerializedName("Name")
    @Expose
    val name: String?
)