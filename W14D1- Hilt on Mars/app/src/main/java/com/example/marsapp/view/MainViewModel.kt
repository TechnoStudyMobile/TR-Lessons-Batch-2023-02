package com.example.marsapp.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.marsapp.data.MarsResponseItem
import com.example.marsapp.repo.MarsPropertyRepostory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MarsPropertyRepostory
) : ViewModel() {

    val properties: LiveData<List<MarsResponseItem>> =
        repository.getAllProperties().asLiveData()

    fun filterProperties(
        minPrice: Int? = null,
        maxPrice: Int? = null
    ): LiveData<List<MarsResponseItem>> {
        val propertiesFlow = repository.getAllProperties()

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
