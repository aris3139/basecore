package com.base.base_source.domain.repository

import com.base.base_source.data.Resource
import com.base.base_source.domain.model.Feed
import kotlinx.coroutines.flow.Flow

/**
 * Base interface for all repositories in the domain layer.
 * This is a marker interface to identify repository components.
 */
interface FeedRepository {
    fun getFeeds(): Flow<Resource<List<Feed>>>
    fun getFeed(id: Int): Flow<Resource<Feed>>
}
