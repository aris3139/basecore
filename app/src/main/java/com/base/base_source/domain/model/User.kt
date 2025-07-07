package com.base.base_source.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val email: String,
    val ipAddress: String,
) : Parcelable {
    val fullName: String
        get() = "$firstName $lastName"
}