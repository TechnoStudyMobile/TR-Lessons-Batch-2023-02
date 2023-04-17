package com.example.foodmenuapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


sealed class MenuModel {
    data class Header(
        val menuTitle: String
    ) : MenuModel()

    @Parcelize
    data class MenuItems(
        val menuName: String,
        val menuDesc: String,
        val amount: String,
        val imageResource: Int
    ) : MenuModel(), Parcelable
}
