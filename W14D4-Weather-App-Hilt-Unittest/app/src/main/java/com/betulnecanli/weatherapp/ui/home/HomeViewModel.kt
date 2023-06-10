package com.betulnecanli.weatherapp.ui.home

import androidx.lifecycle.*
import com.betulnecanli.weatherapp.model.WeatherResponse
import com.betulnecanli.weatherapp.repository.WeatherRepository
import com.betulnecanli.weatherapp.repository.WeatherRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository : WeatherRepositoryInterface
) : ViewModel() {

    val weatherData: MutableLiveData<WeatherResponse?> = MutableLiveData()

    fun getDataFromService(latitude: Double, longitude: Double) = viewModelScope.launch {
        repository.getDataFromService(latitude, longitude).collect { data ->
            weatherData.postValue(data)
        }
    }

}