package com.example.kotlin_rxjavaexample

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.kotlin_rxjavaexample.Example1.Example1Activity
import com.example.kotlin_rxjavaexample.Example2.Example2Activity
import com.example.kotlin_rxjavaexample.Example3.ApiFactory
import com.example.kotlin_rxjavaexample.Example3.Example3Activity
import com.example.kotlin_rxjavaexample.Example4.Example4Activity
import com.google.gson.Gson
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btmExample1 = findViewById<Button>(R.id.btnExample1)
        val btmExample2 = findViewById<Button>(R.id.btnExample2)
        val btmExample3 = findViewById<Button>(R.id.btnExample3)
        val btmExample4 = findViewById<Button>(R.id.btnExample4)

        btmExample1.setOnClickListener { startActivity(Intent(this, Example1Activity::class.java)) }
        btmExample2.setOnClickListener { startActivity(Intent(this, Example2Activity::class.java)) }
        btmExample3.setOnClickListener { startActivity(Intent(this, Example3Activity::class.java)) }
        btmExample4.setOnClickListener { startActivity(Intent(this, Example4Activity::class.java)) }
    }





}