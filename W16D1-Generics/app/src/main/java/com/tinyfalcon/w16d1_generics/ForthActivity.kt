package com.tinyfalcon.w16d1_generics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ForthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forth)

        val a = Deneme()
        a.getMyVariable()

        val b = DenemeGenericFunc()
        b.getMyVariable<String>(30)

        val c = DenemeGenericClass<Float>()
        c.getMyVariable(1.3f)
    }
}


class Deneme {
    fun getMyVariable(): String {
        return ""
    }
}


class DenemeGenericFunc {
    fun <T> getMyVariable(param1: Int): T {
        return param1 as T
    }

    fun getMyVariable2(param1: Int) {

    }
}

class DenemeGenericClass<T> {

    private var myVariable: T? = null

    fun getMyVariable(param: T): T? {
        return myVariable
    }
}