package com.base.base_source.di

import com.base.base_source.data.repository.FeedRepositoryImpl
import com.base.base_source.domain.repository.FeedRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {
    @Binds
    @Singleton
    abstract fun bindFeedRepository(
        feedRepositoryImpl: FeedRepositoryImpl
    ): FeedRepository
}