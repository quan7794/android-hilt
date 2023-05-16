package com.example.samplemodule

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object LocalModules {

    @Provides
    fun provideSampleObj(): SampleObject {
        return SampleObjectImpl()
    }

}