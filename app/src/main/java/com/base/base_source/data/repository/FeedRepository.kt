package com.base.base_source.data.repository

import com.base.base_source.data.entity.Feed
import com.base.base_source.data.local.FeedDao
import com.base.base_source.data.remote.FeedRemoteDataSource
import com.base.base_source.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FeedRepository @Inject constructor(
    private val remoteDataSource: FeedRemoteDataSource,
    private val dao: FeedDao
) {

    fun getFeeds(): Flow<Resource<List<Feed>>> = flow {
        emit(Resource.Loading())
        when (val result = remoteDataSource.getFeeds()) {
            is Resource.Success -> {
                result.data?.let { dao.insertAll(it) }
                emitAll(dao.getAllEntities().map { Resource.Success(it) })
            }

            is Resource.Err -> {
                emit(Resource.Err(result.message!!, null))
                emitAll(dao.getAllEntities().map { Resource.Success(it) })
            }

            else -> emit(Resource.Loading())
        }
    }
}