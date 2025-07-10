package com.base.base_source.di

import com.base.base_source.data.local.feed.FeedLocalDataSource
import com.base.base_source.data.local.feed.FeedLocalDataSourceImpl
import com.base.base_source.data.remote.FeedRemoteRemoteDataSource
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
    fun provideFeedLocalDataSource(
        feedDao: com.base.base_source.data.local.feed.FeedDao
    ): FeedLocalDataSource = FeedLocalDataSourceImpl(
        feedDao = feedDao
    )

    @Singleton
    @Provides
    fun provideRepositoryImpl(
        feedRemoteDataSource: FeedRemoteRemoteDataSource,
        feedLocalDataSource: FeedLocalDataSource
    ) =
        FeedRepositoryImpl(feedRemoteDataSource, feedLocalDataSource)
}