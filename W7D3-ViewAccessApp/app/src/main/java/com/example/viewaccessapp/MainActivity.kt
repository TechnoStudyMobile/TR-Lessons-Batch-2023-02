package com.example.viewaccessapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.viewaccessapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    //Data binding
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // databinding kullanımı
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val user = User("Ömer", 30)
        binding.userXml = user
        binding.buttonTitle = "Button Title"

        val student = Student("Oğuz", false)
        binding.studentXml = student

        binding.textViewName.text = user.name
        binding.textViewAge.text = user.age.toString()


        binding.buttonTest.text = "Data Binding Title"


        //setContentView(R.layout.activity_main)

        //findViewById ile erişim
        /*
         val helloTextView = findViewById<TextView>(R.id.textViewHello)
         val buttonTest = findViewById<Button>(R.id.buttonTest)
        */

        //Kotlin Sythetics kullanı
        /*
         // build.gradle(app) içerisindeki plugin içerisine ---id 'kotlin-android-extensions'--- eklenmeli
         textViewHello.text = "New TEXT"
         buttonTest.text = "New Title"
        */
    }
}