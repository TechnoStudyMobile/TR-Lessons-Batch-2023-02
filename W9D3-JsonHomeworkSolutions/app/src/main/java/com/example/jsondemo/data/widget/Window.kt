package com.example.jsondemo.data.widget


import com.google.gson.annotations.SerializedName

data class Window(
    @SerializedName("height")
    val height: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("width")
    val width: Int
)