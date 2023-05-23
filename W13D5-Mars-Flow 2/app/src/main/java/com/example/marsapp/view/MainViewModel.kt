package com.example.marsapp.view

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.room.Room
import com.example.marsapp.api.MarsApiService
import com.example.marsapp.data.MarsResponseItem
import com.example.marsapp.db.MarsPropertyDao
import com.example.marsapp.db.MarsPropertyDatabase
import com.example.marsapp.repo.MarsPropertyRepostory
import kotlinx.coroutines.flow.map
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(val marsPropertyRepostory: MarsPropertyRepostory) : ViewModel() {

    val properties: LiveData<List<MarsResponseItem>> =
        marsPropertyRepostory.getAllProperties().asLiveData()

    fun filterProperties(
        minPrice: Int? = null,
        maxPrice: Int? = null
    ): LiveData<List<MarsResponseItem>> {
        val propertiesFlow = marsPropertyRepostory.getAllProperties()

        val filteredPropertiesFlow = propertiesFlow.map { properties ->
            var filteredProperties = properties
            if (minPrice != null) {
                filteredProperties = filteredProperties.filter { it.price >= minPrice }
            }
            if (maxPrice != null){
                filteredProperties = filteredProperties.filter { it.price <= maxPrice }
            }
            filteredProperties
        }
        return  filteredPropertiesFlow.asLiveData()
    }

}
