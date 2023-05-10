/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.trackmysleepquality.sleeptracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.android.trackmysleepquality.database.SleepDatabaseDao
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.formatNights
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * ViewModel for SleepTrackerFragment.
 */
class SleepTrackerViewModel(
    private val database: SleepDatabaseDao, application: Application
) : AndroidViewModel(application) {

    private val nights = database.getAllNights()

    val nightsString = Transformations.map(nights) { nights ->
        formatNights(nights, application.resources)
    }

    private var tonight = MutableLiveData<SleepNight?>()

    init {
        initializeTonight()
    }

    private fun initializeTonight() {
        // Step 1
        // Use scope and launch. Move into coroutine.
        // Should be Main thread since we setting a value to LiveData
        // As you know, ViewModel starts on Main Thread. If we do not change the Dispatcher,
        // then we will remain on Main Thread.

        // Adım 1
        // Scope ve launch kullanın. Coroutine içine taşıyın.
        // LiveData'ya bir değer atadığımız için Main Thread kullanılmalıdır.
        // ViewModel, Main Thread üzerinde başlatılır. Eğer Dispatcher'ı değiştirmezsek, Main Thread üzerinde kalırız.
        tonight.value = getTonightFromDatabase()
    }

    // Step 2
    // We are getting error, because getTonight() is database operation.
    // Also, if we call this from launch(), this function needs to have one more keyword, which is?

    // Adım 2
    // Hata alıyoruz, çünkü getTonight() veritabanı işlemidir.
    // Ayrıca, eğer bu fonksiyonu launch() içinden çağırırsak, bu fonksiyona eklememiz gereken bir kelime daha var, o kelime nedir?
    private fun getTonightFromDatabase(): SleepNight? {
        var night = database.getTonight()
        if (night?.endTimeMilli != night?.startTimeMilli) {
            night = null
        }
        return night
    }

    // Step 3
    // Use scope and launch. Move into coroutine.
    // Should be Main thread since we setting a value to LiveData
    // As you know, ViewModel starts on Main Thread. If we do not change the Dispatcher,
    // then we will remain on Main Thread.

    // Adım 3
    // Scope ve launch kullanın. Coroutine içine taşıyın.
    // LiveData'ya bir değer atadığımız için Main Thread kullanılmalıdır.
    // ViewModel, Main Thread üzerinde başlatılır. Eğer Dispatcher'ı değiştirmezsek, Main Thread üzerinde kalırız.
    fun onStartTracking() {

        val newNight = SleepNight()
        insert(newNight)
        tonight.value = getTonightFromDatabase()

    }

    // Step 4. Fix the rest of the code accordingly. Use coroutines anywhere you should.

    // Adım 4. Kodun geri kalanını düzeltin. Gerektiği her yerde coroutines kullanın.
    private fun insert(night: SleepNight) {
        database.insert(night)
    }

    fun onStopTracking() {
        val oldNight = tonight.value ?: return@launch
        oldNight.endTimeMilli = System.currentTimeMillis()
        update(oldNight)
    }

    private fun update(night: SleepNight) {
        database.update(night)
    }

    fun onClear() {
        clear()
        tonight.value = null
    }

    private fun clear() {
        database.clear()
    }
}

