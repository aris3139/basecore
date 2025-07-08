package com.base.base_source.data.remote

import com.base.base_source.data.base.BaseDataSource
import javax.inject.Inject

class FeedRemoteDataSource @Inject constructor(
    private val apiService: APIService
) : BaseDataSource() {
    suspend fun getFeeds() = getResult { apiService.getFeeds() }
    suspend fun getFeed(id: Int) = getResult { apiService.getFeed(id) }
}