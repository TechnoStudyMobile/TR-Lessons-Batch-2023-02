package com.tinyfalcon.w16d1_generics

import android.content.SharedPreferences

fun <T> SharedPreferences.save(var1: String, var2: T) {
    val editor = edit()
    when(var2) {
        is String -> editor.putString(var1, var2)
        is Int -> editor.putInt(var1, var2)
    }
    editor.apply()
}