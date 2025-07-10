package com.base.base_source.data.mapper

import com.base.base_source.data.entity.FeedEntity
import com.base.base_source.domain.model.Feed

object FeedMapper {
    fun dataToDomain(feedEntity: FeedEntity): Feed {
        return Feed(
            id = feedEntity.id,
            description = feedEntity.description,
            avatar = feedEntity.avatar,
            username = feedEntity.username,
            place = feedEntity.place
        )
    }

    fun domainToData(feed: Feed): FeedEntity {
        return FeedEntity(
            id = feed.id,
            description = feed.description,
            avatar = feed.avatar,
            username = feed.username,
            place = feed.place
        )
    }

    fun dataListToDomainList(feedEntities: List<FeedEntity>): List<Feed> {
        return feedEntities.map { dataToDomain(it) }
    }

    fun domainListToDataList(feeds: List<Feed>): List<FeedEntity> {
        return feeds.map { domainToData(it) }
    }
}