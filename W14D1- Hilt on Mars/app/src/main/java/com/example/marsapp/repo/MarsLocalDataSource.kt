package com.example.marsapp.repo

import com.example.marsapp.data.MarsResponseItem
import com.example.marsapp.db.MarsPropertyDao

class MarsLocalDataSource(
    private val marsPropertyDao: MarsPropertyDao
) {
    fun insertProperties(properties: List<MarsResponseItem>) {
        marsPropertyDao.insertPropertiesToRoomDb(properties)
    }

    fun getAllPropertiesFromRoomDb() =
        marsPropertyDao.getAllPropertiesFromRoomDb()
}