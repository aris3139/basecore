package com.base.base_source.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Feed(
    val id: String,
    val username: String,
    val description: String,
    val avatar: String?,
    val place: String
)