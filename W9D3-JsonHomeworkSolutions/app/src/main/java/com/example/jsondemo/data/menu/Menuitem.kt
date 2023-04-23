package com.example.jsondemo.data.menu


import com.google.gson.annotations.SerializedName

data class Menuitem(
    @SerializedName("onclick")
    val onclick: String,
    @SerializedName("value")
    val value: String
)