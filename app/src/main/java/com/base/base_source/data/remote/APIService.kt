package com.base.base_source.data.remote


import com.base.base_source.data.entity.Feed
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("api/feeds")
    suspend fun getFeeds(): Response<List<Feed>>

    @GET("beer/{id}")
    suspend fun getFeed(
        @Path("id") id: Int
    ): Response<Feed>
}