package com.example.jsondemo.data.widget


import com.google.gson.annotations.SerializedName

data class WidgetResponse(
    @SerializedName("widget")
    val widget: Widget
)