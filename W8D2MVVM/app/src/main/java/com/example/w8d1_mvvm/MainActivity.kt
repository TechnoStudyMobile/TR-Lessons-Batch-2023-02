package com.example.w8d1_mvvm

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //private val viewModel = MainViewModel()

    private val viewModel: MainViewModel by viewModels()

    //private val presenter = MainPresenter(this)

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
        //presenter.getWeather()

        // mvvm
        viewModel.getWeather()
        viewModel._weatherListLiveData.observe(this) {
            showColdWeather(it)
        }

        //viewModel.getWeather()

        // business logic - viewmodel - presenter - controller
        /*
        val coldWeatherList = arrayListOf<Weather>()
        for (weather in myWeatherList) {
            // check location, check clock
            if (weather.temp < 12) {
                coldWeatherList.add(weather)
                weather.color = Color.BLUE
            } else  {
                weather.color = Color.RED
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

        val coldWeather = coldWeatherList[0];
        displayText.color = coldWeather.color
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