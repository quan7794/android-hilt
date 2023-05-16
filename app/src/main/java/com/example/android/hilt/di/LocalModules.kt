package com.example.android.hilt.di

import android.content.Context
import androidx.room.Room
import com.example.android.hilt.data.local.AppDatabase
import com.example.android.hilt.data.local.LogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object LocalModules {

    @Provides
    fun provideLogDao(appDb: AppDatabase): LogDao {
        return appDb.logDao()
    }

    @Provides @Singleton
    fun provideAppDb(@ApplicationContext applicationContext: Context) : AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "logging.db"
        ).build()
    }
}