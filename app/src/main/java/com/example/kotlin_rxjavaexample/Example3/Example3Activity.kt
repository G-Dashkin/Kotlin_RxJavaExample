package com.example.kotlin_rxjavaexample.Example3

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.kotlin_rxjavaexample.Example3.ApiService.Companion.BASIC_URL
import com.example.kotlin_rxjavaexample.R
import com.google.gson.Gson
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.sql.Timestamp
import java.util.*
import java.util.concurrent.TimeUnit

class Example3Activity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example3)

        // Пример постоянного отслеживания данных (криптовалюты) при пмощи RxJava

        val disposable = ApiFactory.apiService.getTopCoinsInfo(limit = 50)
            .delaySubscription(3, TimeUnit.SECONDS)
            .repeat()
            .retry()
            .subscribeOn(Schedulers.io())
            .subscribe({

            Log.d("MyLog", "------------------------------------")
            Log.d("MyLog", BASIC_URL)
            Log.d("MyLog", "${it.data!![0].raw.usd.fromSymbol.toString()} " +
                            "Price: ${it.data[0].raw.usd.price.toString()} " +
                                      it.data[0].raw.usd.toSymbol.toString())
            Log.d("MyLog", "Last Update: ${Timestamp(it.data[0].raw.usd.lastUpdate!!.toLong()).toString()
                                                   .split(" ")[1]
                                                   .split(".")[0]}")

        }, {
            Log.d("MyLog", "Failure: ${it.message}")
        })
        compositeDisposable.add(disposable)
    }

}