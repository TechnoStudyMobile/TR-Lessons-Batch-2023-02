package com.example.w8d1_mvvm

import androidx.lifecycle.MutableLiveData

class MainViewModel {

    //val weatherList: List<Weather>

    val weatherListLiveData = MutableLiveData<List<Weather>>()

    // LiveData -> MutableLiveData
    // List -> ArrayList

    fun getWeather() {
        val myWeatherList = arrayListOf<Weather>()
        myWeatherList.add(Weather(temp = 30, city = "Antalya"))
        myWeatherList.add(Weather(temp = 10, city = "Ankara"))
        myWeatherList.add(Weather(temp = 15, city = "İstanbul"))
        analyseWeather(myWeatherList)
    }

    fun analyseWeather(weatherList: List<Weather>) {
        val coldWeatherList = arrayListOf<Weather>()
        for (weather in weatherList) {
            if (weather.temp < 12) {
                coldWeatherList.add(weather)
            }
        }
        weatherListLiveData.value = coldWeatherList
    }
}


// MVP
class MainPresenter(private val activity: MainActivity) {

    // model
    fun getWeather() {
        val myWeatherList = arrayListOf<Weather>()
        myWeatherList.add(Weather(temp = 30, city = "Antalya"))
        myWeatherList.add(Weather(temp = 10, city = "Ankara"))
        myWeatherList.add(Weather(temp = 15, city = "İstanbul"))
        analyseWeather(myWeatherList)
    }

    private fun analyseWeather(weatherList: List<Weather>) {
        val coldWeatherList = arrayListOf<Weather>()
        for (weather in weatherList) {
            if (weather.temp < 12) {
                coldWeatherList.add(weather)
            }
        }
        activity.showColdWeather(coldWeatherList)
    }
}