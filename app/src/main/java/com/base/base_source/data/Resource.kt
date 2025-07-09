package com.base.base_source.data

sealed interface Resource<out T> {

    data class Success<out T>(
        val data: T,
        val isCached: Boolean = false
    ) : Resource<T>

    data class Error(
        val message: String = "",
        val cause: Throwable? = null
    ) : Resource<Nothing>

    object Loading : Resource<Nothing>
    object Empty : Resource<Nothing>

    val value: T?
        get() = when (this) {
            is Success -> data
            else -> null
        }

    fun isSuccess(): Boolean = this is Success
    fun isError(): Boolean = this is Error
    fun isLoading(): Boolean = this === Loading
}
