package com.tinyfalcon.w16d1_generics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a = returnsInt(10)
        val b = returnsString("hello")
        val square: Int = a * a

        val aa = handleInput(10)
        val bb = handleInput("hello")
        // val square2: Int = aa * aa  compile error

        val aaa = handleInputGeneric(10)
        val bbb = handleInputGeneric("hello")
        val square3: Int = aaa * aaa
    }

    private fun <T> handleInputGeneric(param: T): T {
        return param
    }

    private fun handleInput(param: Any): Any? {
        val returnValue = when(param) {
            is Int -> returnsInt(param)
            is String -> returnsString(param)
            else -> null
        }
        return returnValue
    }

    private fun returnsInt(param: Int): Int {
        return param
    }

    private fun returnsString(param: String): String {
        return param
    }
}