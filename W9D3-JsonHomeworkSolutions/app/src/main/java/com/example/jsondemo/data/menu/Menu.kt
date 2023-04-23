package com.example.jsondemo.data.menu


import com.google.gson.annotations.SerializedName

data class Menu(
    @SerializedName("id")
    val id: String,
    @SerializedName("popup")
    val popup: Popup,
    @SerializedName("value")
    val value: String
)