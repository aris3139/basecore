package com.base.base_source.data.remote

import com.base.base_source.data.base.BaseRemoteDataSource
import javax.inject.Inject

class FeedRemoteRemoteDataSource @Inject constructor(
    private val apiService: APIService
) : BaseRemoteDataSource() {
    suspend fun getFeeds() = getResult { apiService.getFeeds() }
    suspend fun getFeed(id: Int) = getResult { apiService.getFeed(id) }
}