package com.example.marsapp.repo

import com.example.marsapp.api.MarsApiService

class MarsRemoteDataSource(
    private val marsApiService: MarsApiService
) {
    suspend fun getProperties() = marsApiService.getProperties()
}