package com.base.base_source.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.base.base_source.data.entity.FeedEntity
import com.base.base_source.data.local.feed.FeedDao
import com.base.base_source.utils.ROOM_DB_NAME


@Database(entities = [FeedEntity::class], version = 4, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun feedDao(): FeedDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, ROOM_DB_NAME)
                .fallbackToDestructiveMigration(false)
                .build()
    }
}
