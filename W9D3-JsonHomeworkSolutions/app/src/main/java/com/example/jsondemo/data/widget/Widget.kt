package com.example.jsondemo.data.widget


import com.google.gson.annotations.SerializedName

data class Widget(
    @SerializedName("debug")
    val debug: String,
    @SerializedName("image")
    val image: İmage,
    @SerializedName("text")
    val text: Text,
    @SerializedName("window")
    val window: Window
)