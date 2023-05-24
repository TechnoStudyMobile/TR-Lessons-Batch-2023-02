package com.example.marsapp.view

import android.content.Context
import com.example.marsapp.api.MarsApiService
import com.example.marsapp.db.MarsPropertyDao
import com.example.marsapp.db.MarsPropertyDatabase
import com.example.marsapp.repo.MarsLocalDataSource
import com.example.marsapp.repo.MarsPropertyRepostory
import com.example.marsapp.repo.MarsRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class MainModule {

    @Provides
    fun provideMarsApiService(retrofit: Retrofit): MarsApiService {
        return retrofit.create(MarsApiService::class.java)
    }

    @Provides
    fun provideMarsPropertyDao(database: MarsPropertyDatabase): MarsPropertyDao {
        return database.marsPropertyDao()
    }

    @Provides
    fun provideLocalDataSource(dao: MarsPropertyDao): MarsLocalDataSource {
        return MarsLocalDataSource(dao)
    }

    @Provides
    fun provideRemoteDataSource(apiService: MarsApiService): MarsRemoteDataSource {
        return MarsRemoteDataSource(apiService)
    }

    @Provides
    fun provideMarsRepo(
        @ApplicationContext context: Context,
        localDataSource: MarsLocalDataSource,
        remoteDataSource: MarsRemoteDataSource
    ): MarsPropertyRepostory {
        return MarsPropertyRepostory(context, remoteDataSource, localDataSource)
    }
}