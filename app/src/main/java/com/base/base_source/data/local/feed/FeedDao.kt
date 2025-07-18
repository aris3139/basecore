package com.base.base_source.data.local.feed

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.base.base_source.data.entity.FeedEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FeedDao {
    @Query("SELECT * FROM feeds")
    fun getFeedsLocal(): Flow<List<FeedEntity>>

    @Query("SELECT * FROM feeds WHERE id = :id")
    fun getFeedLocalById(id: Int): Flow<FeedEntity>

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    fun insertFeeds(entities: List<FeedEntity>)

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    fun insertFeed(entity: FeedEntity)
}