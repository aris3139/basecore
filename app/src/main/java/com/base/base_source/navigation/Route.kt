package com.base.base_source.navigation

import kotlinx.serialization.Serializable


@Serializable
object Splash

@Serializable
object Home

@Serializable
data class FeedDetail(
    val feedId: String,
)

@Serializable
data class Settings(
    val theme: String = "system"
)