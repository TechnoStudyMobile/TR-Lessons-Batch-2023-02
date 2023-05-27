package com.betulnecanli.weatherapp.repository

import com.betulnecanli.weatherapp.data.local.WeatherDao
import com.betulnecanli.weatherapp.network.WeatherService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherService: WeatherService,
    private val weatherDao: WeatherDao
) {
    suspend fun getDataFromService() = flow {
        try {
            val weatherResponse = weatherService.getWeatherResult()
            weatherDao.deleteAll()
            weatherDao.insert(weatherResponse)
            emit(weatherResponse)
        } catch (e: Exception) {
            emit(weatherDao.getAll())
        }
    }
}