package com.example.kotlin_rxjavaexample.Example2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.kotlin_rxjavaexample.R
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class Example2Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example2)

        val buttonStart = findViewById<Button>(R.id.btnStartExample2)

        buttonStart.setOnClickListener {
            Observable.just(1, 2, 3)
                .subscribeOn(Schedulers.newThread())
                .subscribe(observer)
        }
    }

    private val observer = object : Observer<Int> {

        override fun onSubscribe(d: Disposable) {
            Log.d("MyLog", "onSubscribe() isDisposed: ${d.isDisposed}")
        }

        override fun onNext(s: Int) {
            Log.d("MyLog", "onNext: $s")
        }

        override fun onError(e: Throwable) {
            Log.d("MyLog", "onError: " + e.message)
        }

        override fun onComplete() {
            Log.d("MyLog", "onComplete()")
        }
    }
}