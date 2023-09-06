package com.example.kotlin_rxjavaexample.Example3

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.kotlin_rxjavaexample.R
import com.google.gson.Gson
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class Example3Activity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example3)

//        val disposable = ApiFactory.apiService.getTopCoinsInfo(limit = 50)
//            .delaySubscription(10, TimeUnit.SECONDS)
//            .repeat()
//            .retry()
//            .subscribeOn(Schedulers.io())
//            .subscribe({
//                Log.d("MyLog", "Success: $it")
//            }, {
//                Log.d("MyLog", "Failure: ${it.message}")
//            })
//
//        compositeDisposable.add(disposable)
//
//        Log.d("MyLog", "Success: $disposable")

        val disposable2 = ApiFactory.apiService.getTopCoinsInfo2(limit = 50).request()
        Log.d("MyLog", disposable2.method())
        Log.d("MyLog", disposable2.body().toString())
        Log.d("MyLog", disposable2.toString())




    }


}