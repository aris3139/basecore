package com.base.base_source.data.repository

import com.base.base_source.data.entity.FeedEntity
import com.base.base_source.data.local.FeedDao
import com.base.base_source.data.mapper.FeedMapper
import com.base.base_source.data.remote.FeedRemoteDataSource
import com.base.base_source.domain.model.Feed
import com.base.base_source.domain.repository.FeedRepository
import com.base.base_source.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FeedRepositoryImpl @Inject constructor(
    private val remoteDataSource: FeedRemoteDataSource,
    private val dao: FeedDao
) : FeedRepository {
    override  fun getFeeds(): Flow<Resource<List<Feed>>> = flow {
        emit(Resource.Loading())
        when (val result = remoteDataSource.getFeeds()) {
            is Resource.Success -> {
                result.data?.let { dao.insertFeeds(it) }
                emitAll(dao.getFeedsLocal().map { entities ->
                    Resource.Success(FeedMapper.dataListToDomainList(entities))
                }
                )
            }

            is Resource.Err -> {
                emit(Resource.Err(result.message!!, null))
                emitAll(dao.getFeedsLocal().map { entities ->
                    Resource.Success(FeedMapper.dataListToDomainList(entities))
                }
                )
            }

            else -> emit(Resource.Loading())
        }
    }

    override  fun getFeed(id: Int): Flow<Resource<Feed>> {
        TODO("Not yet implemented")
    }
}