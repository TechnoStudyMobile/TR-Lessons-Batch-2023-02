package com.example.jsondemo.data.weather


import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("result")
    val result: List<Result>
)