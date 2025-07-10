package com.base.base_source.data.repository

import com.base.base_source.data.Resource
import com.base.base_source.data.flow.FastAccessFlow
import com.base.base_source.data.local.feed.FeedLocalDataSource
import com.base.base_source.data.mapper.FeedMapper
import com.base.base_source.data.remote.FeedRemoteRemoteDataSource
import com.base.base_source.domain.model.Feed
import com.base.base_source.domain.repository.FeedRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class FeedRepositoryImpl @Inject constructor(
    private val remoteDataSource: FeedRemoteRemoteDataSource,
    private val feedLocalDataSource: FeedLocalDataSource
) : FeedRepository {
    override fun getFeeds(): Flow<Resource<List<Feed>>> =
        FastAccessFlow(
            localData = {
                val entities = feedLocalDataSource.getFeedsLocal().first()
                if (entities.isEmpty()) Resource.Empty
                else Resource.Success(entities)
            },
            dataFromServer = {
                val result = remoteDataSource.getFeeds()
                when (result) {
                    is Resource.Success -> {
                        result.data.let { feedLocalDataSource.insertFeeds(it) }
                        Resource.Success(result.data)
                    }

                    is Resource.Error -> Resource.Error(result.message, result.cause)
                    else -> Resource.Empty
                }
            },
            convertDataToDomain = { resource ->
                when (resource) {
                    is Resource.Success -> {
                        Resource.Success(FeedMapper.dataListToDomainList(resource.data))
                    }

                    is Resource.Error -> Resource.Error(resource.message, resource.cause)
                    is Resource.Loading -> Resource.Loading
                    is Resource.Empty -> Resource.Empty
                }
            }
        ).execute()

    override fun getFeed(id: Int): Flow<Resource<Feed>> {
        TODO("Not yet implemented")
    }
}