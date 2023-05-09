package com.example.w11_d5_coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Coroutines başlatma yöntemleri
         *  runBlocking
         *  GlobalScope

         */
        val buttonRunBlock: Button = findViewById(R.id.buttonRunBlock)
        val buttonGlobal: Button = findViewById(R.id.buttonGlobal)
        val buttonContext: Button = findViewById(R.id.buttonContext)
        val buttonNested: Button = findViewById(R.id.buttonNested)
        val buttonSuspend: Button = findViewById(R.id.buttonSuspend)
        val buttonAsync: Button = findViewById(R.id.buttonAsync)


        buttonRunBlock.setOnClickListener {
            println("Scope: Run blocking başladı")
            runBlocking {
                delay(3000)
                println("Scope: Run blocking devam ediyor")
            }
            println("Scope: Run blocking bitti")
        }


        buttonGlobal.setOnClickListener {
            println("Scope: Global Scope başladı")
            GlobalScope.launch {
                delay(3000)
                println("Scope: Global scope devam ediyor")
            }
            println("Scope: Global scope bitti")
        }


        /**
         * CoroutinesScope Contextleri
         *  Dispatchers.Default
         *  Dispatchers.IO
         *  Dispatchers.Main
         *  Dispatcher.Unconfined
         */

        buttonContext.setOnClickListener {

            GlobalScope.launch {

                launch(Dispatchers.Default) {
                    println("Context: Default Thread: ${Thread.currentThread().name}")
                }

                launch(Dispatchers.IO) {
                    println("Context: IO Thread: ${Thread.currentThread().name}")
                }

                launch(Dispatchers.Main) {
                    println("Context: Main Thread: ${Thread.currentThread().name}")
                }

                launch(Dispatchers.Unconfined) {
                    println("Context: Unconfined Thread: ${Thread.currentThread().name}")
                }
            }
        }


        buttonNested.setOnClickListener {

            runBlocking {

                launch {
                    delay(5000)
                    println("Nested: Run blocking")
                }

                coroutineScope {
                    launch {
                        delay(2000)
                        println("Nested: Coroutine Scope")
                    }

                }

                launch(Dispatchers.Main) {


                }

                launch(Dispatchers.IO) {


                }

                GlobalScope.launch {

                }

            }
        }


        /**
         * Suspend Fun
         */

        buttonSuspend.setOnClickListener {
            runBlocking {
                suspendFunction()
            }
        }


        buttonAsync.setOnClickListener {

            val first = calculateFirstValueTest()
            val second = calculateSecondValueTest()
            val sumTest = first + second
            println("async---test $sumTest")

            GlobalScope.launch {

                val startTime = System.currentTimeMillis()

                val firsValueDeferred = async { calculateFirstValue() }
                val secondValueDeffered = async { calculateSecondValue() }

                println("async--- $firsValueDeferred")
                println("async--- $secondValueDeffered")

                val firstValue = firsValueDeferred.await()
                val secondValue = secondValueDeffered.await()


                val sum = firstValue + secondValue

                val endTime = System.currentTimeMillis()

                println("async---Sonuç: $sum")
                println("async---Toplam geçen süre: ${endTime - startTime} ms")


                println("async--- $firsValueDeferred")
                println("async--- $secondValueDeffered")
            }

        }
    }

    private suspend fun suspendFunction() {
        coroutineScope {
            delay(4000)
            println("Suspend: Suspend Function")
            normalFunction()
        }
    }

    private fun normalFunction() {
        println("Suspend: Normal fun")
    }


    suspend fun calculateFirstValue(): Int {
        delay(500)
        return 10
    }

    suspend fun calculateSecondValue(): Int {
        delay(2000)
        return 20
    }

    fun calculateFirstValueTest(): Int {
        Thread.sleep(1000)
        return 10
    }

    fun calculateSecondValueTest(): Int {
        Thread.sleep(500)
        return 20
    }
}