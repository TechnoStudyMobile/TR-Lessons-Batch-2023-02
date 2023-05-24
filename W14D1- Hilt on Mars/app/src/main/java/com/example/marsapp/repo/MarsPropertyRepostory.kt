package com.example.marsapp.repo

import android.content.Context
import androidx.room.Room
import com.example.marsapp.api.MarsApiService
import com.example.marsapp.data.MarsResponseItem
import com.example.marsapp.db.MarsPropertyDao
import com.example.marsapp.db.MarsPropertyDatabase
import com.example.marsapp.util.NetworkUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class MarsPropertyRepostory(
    private val context: Context,
    private val remoteDataSource: MarsRemoteDataSource,
    private val localDataSource: MarsLocalDataSource
) {

    fun getAllProperties(): Flow<List<MarsResponseItem>> = flow {
        if (NetworkUtil.isNetworkConnected(context)){
            val propertiesFromApi = remoteDataSource.getProperties()
            localDataSource.insertProperties(propertiesFromApi)
            emit(propertiesFromApi)
        }else{
            emit(localDataSource.getAllPropertiesFromRoomDb())
        }
    }.flowOn(Dispatchers.IO)
}