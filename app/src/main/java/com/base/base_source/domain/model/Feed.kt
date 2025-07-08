package com.base.base_source.domain.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Feed(
    val id: String,
    val description: String,
    val avatar: String,
    val createdAt: String
)