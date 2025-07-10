package com.base.base_source.ui.base


sealed class ComponentState<T> {
    class Loading<T> : ComponentState<T>()
    data class Success<T>(val data: T) : ComponentState<T>()
    data class Empty<T>(val message: String = "Data Empty") : ComponentState<T>()
    data class Error<T>(val error: String) : ComponentState<T>()
}