package com.example.w8d1_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val viewModel = MainViewModel()

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // model
        /*
        val myWeatherList = arrayListOf<Weather>()
        myWeatherList.add(Weather(temp = 30, city = "Antalya"))
        myWeatherList.add(Weather(temp = 10, city = "Ankara"))
        myWeatherList.add(Weather(temp = 15, city = "İstanbul"))
         */

        // mvp
        presenter.getWeather()

        // mvvm
        viewModel.getWeather()
        viewModel.weatherListLiveData.observe(this) {
            showColdWeather(it)
        }

        //viewModel.getWeather()

        // logic
        /*
        val coldWeatherList = arrayListOf<Weather>()
        for (weather in myWeatherList) {
            if (weather.temp < 12) {
                coldWeatherList.add(weather)
            }
        }
         */

        // view
        /*
        val myText = findViewById<TextView>(R.id.my_text)
        var displayText = ""
        for (weather in coldWeatherList) {
            displayText += weather
        }
        myText.text = displayText

         */
    }

    fun showColdWeather(coldWeatherList: List<Weather>) {
        val myText = findViewById<TextView>(R.id.my_text)
        var displayText = ""
        for (weather in coldWeatherList) {
            displayText += weather
        }
        myText.text = displayText
    }
}