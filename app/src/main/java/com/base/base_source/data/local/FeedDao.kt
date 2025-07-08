package com.base.base_source.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.base.base_source.data.entity.Feed
import kotlinx.coroutines.flow.Flow

@Dao
interface FeedDao {
    @Query("SELECT * FROM feeds")
    fun getAllEntities(): Flow<List<Feed>>

    @Query("SELECT * FROM feeds WHERE id = :id")
    fun getEntity(id: Int): Flow<Feed>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<Feed>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: Feed)
}
