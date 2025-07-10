package com.base.base_source.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.base.base_source.data.Resource
import com.fpl.base.interfaces.ViewEvent
import com.fpl.base.interfaces.ViewModelState
import com.fpl.base.interfaces.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


@Suppress("UNCHECKED_CAST")
abstract class BaseViewModel<VE : ViewEvent, VS : ViewState, VMS : ViewModelState>(
    initState: VMS
) : ViewModel() {

    protected val viewModelState = MutableStateFlow(initState)
    val uiState: StateFlow<VS> = viewModelState
        .map { it.toUiState() as VS }
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState() as VS
        )

    abstract fun onTriggerEvent(event: VE)

    protected fun <T> Resource<T>.reduce(
        onLoading: (() -> Unit)? = null,
        onSuccess: (T) -> Unit,
        onError: (String, Resource.Error) -> Unit,
    ) {
        when (this) {
            is Resource.Loading -> onLoading?.invoke()
            is Resource.Success -> onSuccess(this.data)
            is Resource.Error -> onError.invoke(message, this)
        }
    }
}