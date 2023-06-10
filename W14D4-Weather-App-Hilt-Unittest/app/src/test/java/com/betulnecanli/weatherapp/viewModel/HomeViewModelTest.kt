package com.betulnecanli.weatherapp.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import com.atilsamancioglu.artbookhilttesting.MainCoroutineRule
import com.betulnecanli.weatherapp.getOrAwaitValueTest
import com.betulnecanli.weatherapp.model.CurrentWeather
import com.betulnecanli.weatherapp.model.Daily
import com.betulnecanli.weatherapp.model.WeatherResponse
import com.betulnecanli.weatherapp.repository.FakeWeatherRepository
import com.betulnecanli.weatherapp.ui.home.HomeViewModel
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.CountDownLatch

@ExperimentalCoroutinesApi // Kotlin coroutines API'si ile çalışırken kullanılması gereken anotasyon
class HomeViewModelTest {

    @get:Rule // JUnit testlerinde kullanılan bir anotasyon, her test metodu çalıştırılmadan önce bu kuralı uygular
    var instantTaskExecutorRule = InstantTaskExecutorRule() // LiveData'nın ana thread dışında güncellenmesine izin verir

    @get:Rule // JUnit testlerinde kullanılan bir anotasyon, her test metodu çalıştırılmadan önce bu kuralı uygular
    var mainCoroutineRule = MainCoroutineRule() // Coroutine'lerin test sırasında senkron çalışmasını sağlar

    private lateinit var viewModel: HomeViewModel // Test edilecek ViewModel
    private lateinit var fakeRepository: FakeWeatherRepository // Gerçek repository yerine kullanılacak sahte repository

    @Before // Bu anotasyon, her test metodu çalıştırılmadan önce belirtilen metodu çalıştırır
    fun setup() {
        fakeRepository = FakeWeatherRepository() // Sahte repository'yi oluştur
        viewModel = HomeViewModel(fakeRepository) // ViewModel'ı sahte repository ile oluştur
    }

    @Test // Bu bir test metodu olduğunu belirtir
    fun `when getDataFromService is successful, then update weatherData`() = runBlockingTest { // Testin ismi ve ne test ettiği
        val currentWeather = CurrentWeather(is_day = 1, temperature = 20.0) // Beklenen veriyi oluştur
        val daily = Daily(
            apparent_temperature_max = listOf(25.0),
            apparent_temperature_min = listOf(15.0),
            time = listOf("10:00")
        )
        val expectedResponse = WeatherResponse(current_weather = currentWeather, daily = daily) // Beklenen hava durumu yanıtı

        viewModel.getDataFromService(1.0, 1.0) // ViewModel'daki metodu çağır

        val actualResponse = viewModel.weatherData.getOrAwaitValueTest() // Gerçek yanıtı al

        assertEquals(expectedResponse, actualResponse) // Gerçek ve beklenen yanıtları karşılaştır
    }

    @Test // Bu bir test metodu olduğunu belirtir
    fun `when getDataFromService fails, then weatherData is null`() = runBlockingTest { // Testin ismi ve ne test ettiği
        fakeRepository.setReturnError(true) // Sahte repository'nin hata döndürmesini sağla

        viewModel.getDataFromService(1.0, 1.0) // ViewModel'daki metodu çağır

        val actualResponse = viewModel.weatherData.getOrAwaitValueTest() // Gerçek yanıtı al

        assertNull(actualResponse) // Gerçek yanıtın null olup olmadığını kontrol et
    }
}


