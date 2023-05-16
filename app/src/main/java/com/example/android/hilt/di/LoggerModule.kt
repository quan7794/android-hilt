package com.example.android.hilt.di

import com.example.android.hilt.data.LoggerDataSource
import com.example.android.hilt.data.local.LoggerLocalDataSource
import com.example.android.hilt.data.memory.LoggerMemoryDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class LoggerLocalDsModule {

    @Binds @Singleton @LocalLogger
    abstract fun bindLocalDS(loggerLocalDataSource: LoggerLocalDataSource): LoggerDataSource
}

@InstallIn(ActivityComponent::class)
@Module
abstract class LoggerMemoryDsModule {

    @Binds @ActivityScoped @MemoryLogger
    abstract fun bindMemoryDS(loggerMemoryDataSource: LoggerMemoryDataSource): LoggerDataSource
}

@Qualifier
annotation class LocalLogger
@Qualifier
annotation class MemoryLogger