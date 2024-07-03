package com.base.base_source.di

import android.content.Context
import com.base.base_source.data.local.AppDatabase
import com.base.base_source.data.local.EntityDao
import com.base.base_source.data.remote.APIService
import com.base.base_source.data.remote.EntityRemoteDataSource
import com.base.base_source.data.repository.EntityRepository
import com.base.base_source.datastore.DataStoreManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideEmployeeDao(db: AppDatabase) = db.entityDao()

    @Singleton
    @Provides
    fun provideDataStoreManager(@ApplicationContext context: Context): DataStoreManager {
        return DataStoreManager(context)
    }

    @Provides
    fun provideAPIService(retrofit: Retrofit): APIService =
        retrofit.create(APIService::class.java)

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: EntityRemoteDataSource, localDataSource: EntityDao) =
        EntityRepository(remoteDataSource, localDataSource)
}