package com.example.w8d1_mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    // val weatherList: List<Weather>

    private val weatherListLiveData = MutableLiveData<List<Weather>>()
    // val weatherListLiveData2 = LiveData<List<Weather>>()  -> can't set value, immutable
    public val _weatherListLiveData: LiveData<List<Weather>> = weatherListLiveData

    // LiveData -> MutableLiveData
    // List -> ArrayList

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

        weatherListLiveData.value = coldWeatherList
        // weatherListLiveData.setValue(coldWeatherList)
    }
}


// MVP
class MainPresenter(private val view: MainActivity) {

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
        view.showColdWeather(coldWeatherList)
    }
}