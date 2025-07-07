package com.base.base_source.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.base.base_source.domain.model.User
import com.base.base_source.domain.usecase.GetUsersUseCase
import com.base.base_source.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeComposeViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _uiState = mutableStateOf(HomeUiState())
    val uiState: State<HomeUiState> = _uiState

    init {
        getUsers()
    }

    private fun getUsers() {
        getUsersUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _uiState.value = _uiState.value.copy(
                        users = result.data ?: emptyList(),
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Err -> {
                    _uiState.value = _uiState.value.copy(
                        users = emptyList(),
                        isLoading = false,
                        error = result.message
                    )
                }
                is Resource.Loading -> {
                    _uiState.value = _uiState.value.copy(
                        isLoading = true,
                        error = null
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onRetry() {
        getUsers()
    }
}

data class HomeUiState(
    val users: List<User> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)