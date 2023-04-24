package com.example.w9d1_httprequest

import okhttp3.Interceptor
import okhttp3.Response

class MyCustomInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val myRequest = chain.request().newBuilder()
            .addHeader("Authorization", "fxmskalksmodk23")
            .build()
        return chain.proceed(myRequest)
    }
}