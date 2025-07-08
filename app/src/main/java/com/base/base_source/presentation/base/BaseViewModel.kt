package com.base.base_source.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Base ViewModel class that provides common functionality for all ViewModels.
 * Handles UI states, loading states, and error events.
 */
abstract class BaseViewModel<UiState, UiEvent> : ViewModel() {

    // Represents the current state of the UI
    private val _uiState = MutableStateFlow<UiState?>(null)
    val uiState: StateFlow<UiState?> = _uiState

    // For one-time events like navigation, showing snackbar, etc.
    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent: SharedFlow<UiEvent> = _uiEvent

    // Loading state
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    // Error message
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    /**
     * Updates the UI state
     */
    protected fun updateUiState(state: UiState) {
        _uiState.value = state
    }

    /**
     * Emits a UI event
     */
    protected fun emitUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.emit(event)
        }
    }

    /**
     * Updates the loading state
     */
    protected fun setLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }

    /**
     * Sets an error message
     */
    protected fun setErrorMessage(message: String?) {
        _errorMessage.value = message
    }

    /**
     * Executes a suspending operation with automatic loading state handling
     */
    protected fun launchWithLoading(block: suspend () -> Unit) {
        viewModelScope.launch {
            try {
                setLoading(true)
                block()
            } catch (e: Exception) {
                setErrorMessage(e.message)
            } finally {
                setLoading(false)
            }
        }
    }
}
