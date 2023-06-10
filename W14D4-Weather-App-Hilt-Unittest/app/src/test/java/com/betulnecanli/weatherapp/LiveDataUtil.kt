package com.betulnecanli.weatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

/* Copyright 2019 Google LLC.
   SPDX-License-Identifier: Apache-2.0 */

fun <T> LiveData<T>.getOrAwaitValueTest(
    time: Long = 2, // Belirli bir süre boyunca beklemek için varsayılan zamanı tanımlar
    timeUnit: TimeUnit = TimeUnit.SECONDS // Varsayılan zaman birimini tanımlar (saniye)
): T {
    var data: T? = null // Veriyi saklamak için bir değişken tanımlar
    val latch = CountDownLatch(1) // Verinin ayarlanmasını beklemek için bir CountDownLatch oluşturur

    // LiveData verisinin değiştiğinde ne yapılacağını tanımlayan bir gözlemci (observer) oluşturur
    val observer = object : Observer<T> {
        override fun onChanged(value: T) {
            data = value // Veriyi alır ve saklar
            latch.countDown() // CountDownLatch'ın sayısını azaltır, bu da verinin alındığını belirtir
            this@getOrAwaitValueTest.removeObserver(this) // Gözlemciyi kaldırır çünkü artık gerekli değildir
        }
    }

    // LiveData verisini sürekli olarak gözlemlemeye başlar
    this.observeForever(observer)

    // Eğer veri belirli bir süre içinde ayarlanmazsa bir hata atar
    // Bu, testin sonsuza kadar beklemesini engeller
    if (!latch.await(time, timeUnit)) {
        throw TimeoutException("LiveData value was never set.")
    }

    // Sonuç olarak alınan veriyi döndürür
    // Eğer veri null ise, bir hata atar (çünkü beklenen T tipi null olmayan bir değerdir)
    @Suppress("UNCHECKED_CAST")
    return data as T
}

