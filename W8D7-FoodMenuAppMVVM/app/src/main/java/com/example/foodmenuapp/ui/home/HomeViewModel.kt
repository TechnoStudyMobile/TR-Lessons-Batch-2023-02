package com.example.foodmenuapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodmenuapp.R
import com.example.foodmenuapp.model.MenuModel

class HomeViewModel: ViewModel() {

    private val _menuList = MutableLiveData<List<MenuModel>>()
    val menuList: LiveData<List<MenuModel>> = _menuList

    fun getMenuList() {
        _menuList.value = getMockData()
    }

    private fun getMockData(): List<MenuModel> = listOf(
        MenuModel.Header(menuTitle = "Ayın Menüleri"),
        MenuModel.MenuItems(
            "Xtreme Menu",
            "(1 k!ş!l!k) Z!nger Burger, 4 parça Hot Shots, 2 adet Acılı Kanat, Coleslaw, Püre, !çecek !le",
            "115 TL",
            R.drawable.ic_menu_one
        ),
        MenuModel.MenuItems(
            "Kafana Göre Kova",
            "D!led!ğ!n lezzet! d!led!ğ!n kadar terc!h et, kend! kovanı kend!n yarat (En az 1 adet kanat terc!h! yapılmalıdır.)",
            "140 TL",
            R.drawable.ic_menu_two
        ),
        MenuModel.Header(menuTitle = "Ramazan Menüleri"),
        MenuModel.MenuItems(
            "8’l! Kanat Menu",
            "(1 k!ş!l!k) 8 Parça Kanat, Küçük Boy Patates Kızartması, İçecek (330 ml)",
            "90 TL",
            R.drawable.ic_menu_theree
        ),
        MenuModel.MenuItems(
            "Best Of Menu",
            "(1 K!ş!l!k) 1 parça But, 2 adet Acılı Kanat, 2 parça Kem!ks!z Çıtır, 6'lı Çıtır Shots, 1 adet B!scu!t, Püre, İçecek (330 ml)",
            "120 TL",
            R.drawable.ic_menu_four
        ),
        MenuModel.MenuItems(
            "8’l! Kanat Menu",
            "(1 k!ş!l!k) 8 Parça Kanat, Küçük Boy Patates Kızartması, İçecek (330 ml)",
            "90 TL",
            R.drawable.ic_menu_theree
        ),
        MenuModel.MenuItems(
            "Best Of Menu",
            "(1 K!ş!l!k) 1 parça But, 2 adet Acılı Kanat, 2 parça Kem!ks!z Çıtır, 6'lı Çıtır Shots, 1 adet B!scu!t, Püre, İçecek (330 ml)",
            "120 TL",
            R.drawable.ic_menu_four
        ),
        MenuModel.MenuItems(
            "8’l! Kanat Menu",
            "(1 k!ş!l!k) 8 Parça Kanat, Küçük Boy Patates Kızartması, İçecek (330 ml)",
            "90 TL",
            R.drawable.ic_menu_theree
        ),
        MenuModel.MenuItems(
            "Best Of Menu",
            "(1 K!ş!l!k) 1 parça But, 2 adet Acılı Kanat, 2 parça Kem!ks!z Çıtır, 6'lı Çıtır Shots, 1 adet B!scu!t, Püre, İçecek (330 ml)",
            "120 TL",
            R.drawable.ic_menu_four
        ),

        MenuModel.MenuItems(
            "8’l! Kanat Menu",
            "(1 k!ş!l!k) 8 Parça Kanat, Küçük Boy Patates Kızartması, İçecek (330 ml)",
            "90 TL",
            R.drawable.ic_menu_theree
        ),
        MenuModel.MenuItems(
            "Best Of Menu",
            "(1 K!ş!l!k) 1 parça But, 2 adet Acılı Kanat, 2 parça Kem!ks!z Çıtır, 6'lı Çıtır Shots, 1 adet B!scu!t, Püre, İçecek (330 ml)",
            "120 TL",
            R.drawable.ic_menu_four
        )
    )
}