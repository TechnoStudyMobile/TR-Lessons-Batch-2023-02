package com.example.marsapp.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.marsapp.repo.MarsPropertyRepostory

class MarsViewModelFactory(private val marsPropertyRepository: MarsPropertyRepostory) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(marsPropertyRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}