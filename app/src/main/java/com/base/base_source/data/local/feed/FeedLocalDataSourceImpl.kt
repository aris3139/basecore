package com.base.base_source.data.local.feed

import com.base.base_source.data.entity.FeedEntity
import javax.inject.Inject

class FeedLocalDataSourceImpl @Inject constructor(
    private val feedDao: FeedDao
) : FeedLocalDataSource {
    override fun getFeedsLocal() = feedDao.getFeedsLocal()
    override fun insertFeeds(feeds: List<FeedEntity>) = feedDao.insertFeeds(feeds)
}