package com.base.base_source.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "feeds")
data class FeedEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val description: String,
    val avatar: String,
    @SerializedName("createdAt")
    val createdAt: String
) : Parcelable
