package com.example.jsondemo.data.widget


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("alignment")
    val alignment: String,
    @SerializedName("hOffset")
    val hOffset: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("src")
    val src: String,
    @SerializedName("vOffset")
    val vOffset: Int
)