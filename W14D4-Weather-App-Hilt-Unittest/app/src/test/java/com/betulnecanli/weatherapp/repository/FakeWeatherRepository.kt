package com.betulnecanli.weatherapp.repository

import com.betulnecanli.weatherapp.model.CurrentWeather
import com.betulnecanli.weatherapp.model.Daily
import com.betulnecanli.weatherapp.model.WeatherResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
// Sahte WeatherRepository oluşturuluyor. Bu, test sırasında gerçek repository yerine kullanılacak.
class FakeWeatherRepository : WeatherRepositoryInterface {

    // Hata döndürüp döndürmemesi gerektiğini kontrol edecek bir değişken
    private var shouldReturnError = false

    // Hata döndürme durumunu ayarlamak için bir metot
    fun setReturnError(value: Boolean) {
        shouldReturnError = value
    }

    // WeatherRepositoryInterface'inden gelen metodu uyguluyoruz
    override suspend fun getDataFromService(
        latitude: Double, // enlem
        longitude: Double // boylam
    ): Flow<WeatherResponse?> = flow { // Kotlin coroutines flow'unu kullanıyoruz

        // Eğer hata döndürme durumu doğruysa
        if (shouldReturnError) {
            emit(null) // null değer döndür
        } else {
            // Aksi halde, başarılı bir yanıt döndür

            // Test için kullanacağımız sabit hava durumu verisi
            val currentWeather = CurrentWeather(is_day = 1, temperature = 20.0)
            val daily = Daily(apparent_temperature_max = listOf(25.0), apparent_temperature_min = listOf(15.0), time = listOf("10:00"))

            // Bu veriyi WeatherResponse objesi içinde döndür
            emit(WeatherResponse(current_weather = currentWeather, daily = daily))
        }
    }
}


