package com.tinyfalcon.w16d1_generics

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ThirdActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        save("key", "value")

        // saveGeneric("deneme", "key", "value")  => compiler error
        saveGeneric(this, "key", "value")
    }
}


abstract class BaseActivity: AppCompatActivity() {
    // @Inject
    lateinit var preferences: SharedPreferences

    fun <T> save(var1: String, var2: T) {
        preferences.save(var1, var2)
    }
}


fun <A : BaseActivity, T> saveGeneric(activity: A, var1: String, var2: T) {
    activity.save(var1, var2)
}