package com.example.jsondemo.data.widget


import com.google.gson.annotations.SerializedName

data class Text(
    @SerializedName("alignment")
    val alignment: String,
    @SerializedName("data")
    val `data`: String,
    @SerializedName("hOffset")
    val hOffset: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("onMouseUp")
    val onMouseUp: String,
    @SerializedName("size")
    val size: Int,
    @SerializedName("style")
    val style: String,
    @SerializedName("vOffset")
    val vOffset: Int
)