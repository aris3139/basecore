package com.base.base_source.data.local.feed

import com.base.base_source.data.entity.FeedEntity
import kotlinx.coroutines.flow.Flow

interface FeedLocalDataSource {
    fun getFeedsLocal(): Flow<List<FeedEntity>>
    fun insertFeeds(feeds: List<FeedEntity>)
}