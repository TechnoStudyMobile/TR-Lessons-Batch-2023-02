package com.betulnecanli.weatherapp.ui.home

import android.app.Application
import androidx.lifecycle.*
import com.betulnecanli.weatherapp.data.local.WeatherDB
import com.betulnecanli.weatherapp.model.WeatherResponse
import com.betulnecanli.weatherapp.network.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val weatherService = WeatherService.create()
    private val weatherDb = WeatherDB.getInstance(application.applicationContext)

    private val _weatherData = MutableLiveData<WeatherResponse?>()
    val weatherData: LiveData<WeatherResponse?> = _weatherData

    fun getDataFromService() {
        weatherService.getWeatherResult().enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                weatherResponse: Response<WeatherResponse>
            ) {
                if (weatherResponse.isSuccessful) {
                    val response = weatherResponse.body()
                    _weatherData.value = response
                    Thread(Runnable {
                        weatherDb.weatherDao().deleteAll()
                        response?.let { weatherDb.weatherDao().insert(it) }
                    }).start()
                }
            }
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Thread(Runnable {
                    val weatherList = weatherDb.weatherDao().getAll()
                    _weatherData.postValue(weatherList)
                }).start()
            }
        })
    }
}