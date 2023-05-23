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
    private val marsApiService: MarsApiService
) {

    private lateinit var marsPropertyDao: MarsPropertyDao

    init {
        val marsPropertyDatabase = Room.databaseBuilder(
            context.applicationContext,
            MarsPropertyDatabase::class.java,
            "name_property_database"
        ).build()

        marsPropertyDao = marsPropertyDatabase.marsPropertyDao()
    }

    fun insertProperties(properties: List<MarsResponseItem>) {
        marsPropertyDao.insertPropertiesToRoomDb(properties)
    }

    fun getAllProperties(): Flow<List<MarsResponseItem>> = flow {
        if (NetworkUtil.isNetworkConnected(context)){
            val propertiesFromApi = marsApiService.getProperties()
            insertProperties(propertiesFromApi)
            emit(propertiesFromApi)
        }else{
            emit(marsPropertyDao.getAllPropertiesFromRoomDb())
        }
    }.flowOn(Dispatchers.IO)
}