package com.example.jsondemo.data.menu


import com.google.gson.annotations.SerializedName

data class MenuResponse(
    @SerializedName("menu")
    val menu: Menu
)