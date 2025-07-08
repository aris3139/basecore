package com.base.base_source.ui.home

import com.base.base_source.domain.model.Feed
import com.base.base_source.domain.usecase.GetFeedsUseCase
import com.base.base_source.presentation.base.BaseViewModel
import com.base.base_source.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

// Define UI State for Home screen
data class HomeUIState(
    val entities: List<Feed> = emptyList(),
    val isRefreshing: Boolean = false
)

// Define UI Events for Home screen
sealed class HomeUIEvent {
    data class NavigateToEntityDetail(val entityId: String) : HomeUIEvent()
    object ShowRefreshMessage : HomeUIEvent()
}

@HiltViewModel
class HomeVM @Inject constructor(
    private val feedUseCas: GetFeedsUseCase
) : BaseViewModel<HomeUIState, HomeUIEvent>() {

    private val _entities = MutableStateFlow<Resource<List<Feed>>>(Resource.Loading())
    val entities: StateFlow<Resource<List<Feed>>> = _entities

    init {
        updateUiState(HomeUIState())
        loadEntities()
    }

    private fun loadEntities() {
        launchWithLoading {
            feedUseCas.invoke().collect { resource ->
                _entities.value = resource


                when (resource) {
                    is Resource.Success -> {
                        updateUiState(HomeUIState(entities = resource.data ?: emptyList()))
                    }

                    is Resource.Loading -> {
                    }

                    is Resource.Err -> {
                    }
                }
            }
        }
    }
}