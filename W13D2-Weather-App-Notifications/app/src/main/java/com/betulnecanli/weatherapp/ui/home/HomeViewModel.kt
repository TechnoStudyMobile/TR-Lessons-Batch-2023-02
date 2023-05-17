package com.betulnecanli.weatherapp.ui.home

import androidx.lifecycle.*
import com.betulnecanli.weatherapp.model.WeatherResponse
import com.betulnecanli.weatherapp.repository.WeatherRepository


class HomeViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    private val _weatherData = MutableLiveData<WeatherResponse?>()
    val weatherData: LiveData<WeatherResponse?> = _weatherData

    fun getDataFromService() {
        weatherRepository.getDataFromService {
            _weatherData.postValue(it)
        }
    }
}