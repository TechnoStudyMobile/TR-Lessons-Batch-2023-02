package com.example.marsapp.view

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.example.marsapp.api.MarsApiService
import com.example.marsapp.data.MarsResponseItem
import com.example.marsapp.db.MarsPropertyDao
import com.example.marsapp.db.MarsPropertyDatabase
import com.example.marsapp.repo.MarsPropertyRepostory
import retrofit2.Callback
import retrofit2.Response


class MainViewModel : ViewModel() {

    private val marsApiService = MarsApiService.create()

    private val _properties = MutableLiveData<List<MarsResponseItem>>()
    val properties: LiveData<List<MarsResponseItem>> = _properties

    private val _filteredProperties = MutableLiveData<List<MarsResponseItem>>()
    val filteredProperties: LiveData<List<MarsResponseItem>> = _filteredProperties

    init {

        /**
        App i ilk çalıştırdığınızdan bu servisi çağırın ki datalar servisten gelsin
         */

        // marsServiceCall()

        /**
         *  Databaseden verileri çeken methodu çağırdık,
         *  Uygulamayı ilk yükleyip çalıştırdığınızda marsServiceCall u çalıştırırsak dataları serverden çekecek
         *  Sonrosında marsServiceCall() methodunu yorum satırı haline getirip loadPropertiesFromDataBase() i kullanabilirsiniz
         */
        loadPropertiesFromDataBase()
    }

    private fun filterPropertiesByPrice(
        properties: List<MarsResponseItem>,
        maxPrice: Int
    ): List<MarsResponseItem> {
        return properties.filter { it.price < maxPrice }
    }

    fun filterWithPrice(price: Int) {
        _properties.value?.filter { it.price <= price }
    }


    /**
     *  Database e kaydedilen datayı çekmek için ekledik
     */

    private fun loadPropertiesFromDataBase() {
        MarsPropertyRepostory.getAllPropertis { properties ->
            _properties.postValue(properties)
        }
    }


    fun getFilterServiceCall(filter: String) {
        // https://mars.udacity.com/realestate?filter=buy
        val marsPropertiesWithFilterCall = marsApiService.getPropertiesWithFilter(filter)
        marsPropertiesWithFilterCall.enqueue(object : Callback<List<MarsResponseItem>> {

            override fun onResponse(
                call: retrofit2.Call<List<MarsResponseItem>>,
                response: Response<List<MarsResponseItem>>
            ) {
                if (response.isSuccessful) {
                    _properties.value = response.body()
                } else {

                }
            }

            override fun onFailure(call: retrofit2.Call<List<MarsResponseItem>>, t: Throwable) {

                //Hata işleme
            }
        })
    }


    fun marsServiceCall() {
        marsApiService.getProperties().enqueue(object : Callback<List<MarsResponseItem>> {

            override fun onResponse(
                call: retrofit2.Call<List<MarsResponseItem>>,
                response: Response<List<MarsResponseItem>>
            ) {
                if (response.isSuccessful) {
                    _properties.value = response.body()
                    response.body()?.let {
                        MarsPropertyRepostory.insertProperties(it) { succes ->

                            if (succes) {
                                //Log işlemi
                            } else {

                            }

                        }
                    }

                } else {

                }
            }

            override fun onFailure(call: retrofit2.Call<List<MarsResponseItem>>, t: Throwable) {
                //Hata işleme
            }
        })
    }
}
