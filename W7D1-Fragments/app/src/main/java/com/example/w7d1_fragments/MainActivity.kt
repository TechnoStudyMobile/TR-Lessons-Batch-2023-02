package com.example.w7d1_fragments

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // MainActivity()
        // new MainActivity()
        val listFragment = ListFragment()
        val detailFragment = DetailFragment()


        supportFragmentManager.beginTransaction()
            .replace(R.id.full_container, listFragment)
            .commit()


        val myButton = findViewById<Button>(R.id.my_button)
        myButton.setOnClickListener {
            // fragment değiştirme kısmı ->

            // gönderilecek veri hazılanıyor
            val myBundle = Bundle()
            myBundle.putInt("my_counter", 10)

            detailFragment.arguments = myBundle

            // sayfa açılıyor
            supportFragmentManager.beginTransaction()
                .replace(R.id.full_container, detailFragment)
                .commit()

        }
    }
}