package com.example.kotlin_rxjavaexample.Example1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.kotlin_rxjavaexample.R
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class Example1Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example1)

        val buttonStart = findViewById<Button>(R.id.btnStartExample1)
        buttonStart.setOnClickListener { startRStream() }
    }

    private fun startRStream() {
        //Create an Observable (Наблюдаемый)//
        val myObservable = observable()

        //Create an Observer (Наблюдатель)//
        val myObserver = observer()

        //Подписка наблюдателя на наблюдаемый объект//
        myObservable.subscribe(myObserver)
    }

    // Сздание наблюдателя (Observer)
    private fun observer(): Observer<String> {
        return object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                Log.d("MyLog", "onSubscribe() isDisposed: ${d.isDisposed}")
            }

            override fun onNext(s: String) {
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

    // Сздание наблюдаемого объекта (Observable)
    private fun observable(): Observable<String> {
        return Observable.just("1", "2", "3", "4", "5")
    }
}