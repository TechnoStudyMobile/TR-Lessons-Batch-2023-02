package com.betulnecanli.weatherapp.ui.home

import androidx.lifecycle.*
import com.betulnecanli.weatherapp.model.WeatherResponse
import com.betulnecanli.weatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val weatherRepository: WeatherRepository) :
    ViewModel() {

    val weatherData: MutableLiveData<WeatherResponse?> = MutableLiveData()

    fun getDataFromService() = viewModelScope.launch {
        weatherRepository.getDataFromService().collect { data ->
            weatherData.postValue(data)
        }
    }
}