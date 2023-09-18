package com.example.kotlin_rxjavaexample.Example3

import com.example.kotlin_rxjavaexample.Example3.models.CoinInfo
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top/totalvolfull")
    fun getTopCoinsInfo(
        @Query(QUERY_PARAM_LIMIT) limit: Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym: String = CURRENCY
    ): Single<CoinInfo>

    companion object {
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val CURRENCY = "USD"
        const val BASIC_URL = "https://min-api.cryptocompare.com/data/top/totalvolfull?limit=50&tsym=USD"
    }
}