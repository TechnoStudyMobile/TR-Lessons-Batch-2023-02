package com.betulnecanli.weatherapp.repository

import com.betulnecanli.weatherapp.model.WeatherResponse
import kotlinx.coroutines.flow.Flow

interface WeatherRepositoryInterface {
    suspend fun getDataFromService(latitude: Double, longitude: Double): Flow<WeatherResponse?>
}
