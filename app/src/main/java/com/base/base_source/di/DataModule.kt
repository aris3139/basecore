package com.base.base_source.di

import com.base.base_source.data.local.FeedDao
import com.base.base_source.data.remote.FeedRemoteDataSource
import com.base.base_source.data.repository.FeedRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun provideRepositoryImpl(
        remoteDataSource: FeedRemoteDataSource,
        localDataSource: FeedDao
    ) =
        FeedRepositoryImpl(remoteDataSource, localDataSource)
}