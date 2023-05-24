package com.example.marsapp.api

import com.example.marsapp.data.MarsResponseItem
import retrofit2.http.GET

interface MarsApiService {

    @GET("realestate?filter=all")
    suspend fun getProperties(): List<MarsResponseItem>
}
