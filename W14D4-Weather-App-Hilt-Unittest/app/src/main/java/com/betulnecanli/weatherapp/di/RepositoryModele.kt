package com.betulnecanli.weatherapp.di

import com.betulnecanli.weatherapp.data.local.WeatherDao
import com.betulnecanli.weatherapp.network.WeatherService
import com.betulnecanli.weatherapp.repository.WeatherRepository
import com.betulnecanli.weatherapp.repository.WeatherRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(
        weatherService: WeatherService,
        weatherDao: WeatherDao
    ): WeatherRepositoryInterface = WeatherRepository(weatherService, weatherDao)

}
