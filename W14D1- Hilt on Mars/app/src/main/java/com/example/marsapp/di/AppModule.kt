package com.example.marsapp.di

import android.content.Context
import androidx.room.Room
import com.example.marsapp.constants.Consts
import com.example.marsapp.db.MarsPropertyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    // TODO : Return type'ı silip de deneyelim

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Consts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MarsPropertyDatabase {
        return Room.databaseBuilder(
            context,
            MarsPropertyDatabase::class.java,
            "name_property_database"
        ).build()
    }
}