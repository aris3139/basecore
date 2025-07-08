package com.base.base_source.di

import com.base.base_source.domain.repository.EntityRepository
import com.base.base_source.domain.usecase.GetEntitiesUseCase
import com.base.base_source.domain.usecase.GetEntityByIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideGetEntitiesUseCase(
        repository: EntityRepository
    ): GetEntitiesUseCase {
        return GetEntitiesUseCase(repository)
    }

    @Provides
    fun provideGetEntityByIdUseCase(
        repository: EntityRepository
    ): GetEntityByIdUseCase {
        return GetEntityByIdUseCase(repository)
    }
}