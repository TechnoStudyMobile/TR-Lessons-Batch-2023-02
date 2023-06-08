package com.tinyfalcon.w16d1_generics

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity() {

    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val editor = preferences.edit()
        editor.putString("key1", "value1")
        editor.putInt("key2", 10)
        editor.apply()

        putGeneric(editor, "key1", "value1")
        putGeneric(editor, "key2", 10)
        editor.apply()

        val editor2 = preferences.edit()
        editor2.put("key1", "value1")
        editor2.put("key2", 10)
        editor2.apply()

        preferences.edit().run {
            put("key1", "value1")
            put("key2", 10)
            apply()
        }

        preferences.save("key1", "value1")
        preferences.save("key2", 10)
    }
    /*
        Editor putString(String var1, @Nullable String var2);
        Editor putInt(String var1, int var2);
     */

    fun <T> putGeneric(editor: SharedPreferences.Editor, var1: String, var2: T) {}

    fun Editor.a() { }

    fun <T> Editor.put(var1: String, var2: T) {
        // no impl
    }

    fun <T> SharedPreferences.save(var1: String, var2: T) {
        val editor = edit()
        when(var2) {
            is String -> editor.putString(var1, var2)
            is Int -> editor.putInt(var1, var2)
        }
        editor.apply()
    }
}


class Editor {
    val deneme = 10
    fun <T> put(editor: SharedPreferences.Editor, var1: String, var2: T) {
        denemeFunc()
        deneme
    }
    fun denemeFunc() {

    }
}