package com.betulnecanli.weatherapp.repository

import com.betulnecanli.weatherapp.data.local.WeatherDB
import com.betulnecanli.weatherapp.model.WeatherResponse
import com.betulnecanli.weatherapp.network.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository(
    private val weatherService: WeatherService,
    private val weatherDb: WeatherDB
    ) {

    fun getDataFromService(callback: (WeatherResponse?) -> Unit) {
        weatherService.getWeatherResult().enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                weatherResponse: Response<WeatherResponse>
            ) {
                if (weatherResponse.isSuccessful) {
                    val response = weatherResponse.body()
                    callback(response)
                    Thread(Runnable {
                        weatherDb.weatherDao().deleteAll()
                        response?.let { weatherDb.weatherDao().insert(it) }
                    }).start()
                }
            }
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Thread(Runnable {
                    val weatherList = weatherDb.weatherDao().getAll()
                    callback(weatherList)
                }).start()
            }
        })
    }
}