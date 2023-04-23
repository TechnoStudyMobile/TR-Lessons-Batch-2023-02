package com.example.jsondemo.data.menu


import com.google.gson.annotations.SerializedName

data class Popup(
    @SerializedName("menuitem")
    val menuItem: List<Menuitem>
)