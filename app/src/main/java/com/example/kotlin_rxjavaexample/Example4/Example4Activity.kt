package com.example.kotlin_rxjavaexample.Example4

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlin_rxjavaexample.databinding.ActivityExample4Binding
import io.reactivex.rxjava3.core.Observable

class Example4Activity : AppCompatActivity() {
    private lateinit var binding: ActivityExample4Binding
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExample4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Пример одного из операторов - .zip()

        val numbers = Observable.range(1, 6)
        val strings = Observable.just("One", "Two", "Three",
            "Four", "Five", "Six" )
        val zipped = Observable.zip(strings, numbers) { s, n ->
            "$s $n"
        }
        zipped.subscribe(){
            Log.d("MyLog", it)
        }
    }
}