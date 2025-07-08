package com.base.base_source.ui.home

import android.util.Log
import com.base.base_source.data.entity.Feed
import com.base.base_source.data.repository.FeedRepository
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
    private val repository: FeedRepository
) : BaseViewModel<HomeUIState, HomeUIEvent>() {

    private val _entities = MutableStateFlow<Resource<List<Feed>>>(Resource.Loading())
    val entities: StateFlow<Resource<List<Feed>>> = _entities

    init {
        updateUiState(HomeUIState())
        loadEntities()
    }

    private fun loadEntities() {
        launchWithLoading {
            repository.getFeeds().collect { resource ->
                _entities.value = resource


                when (resource) {
                    is Resource.Success -> {
                        updateUiState(HomeUIState(entities = resource.data ?: emptyList()))
                        Log.d("aaaaaaaaaa", "loadEntities: 1")
                    }
//                    is Resource.Error -> {
//                        setErrorMessage(resource.message ?: "Unknown error occurred")
//                    }
                    is Resource.Loading -> {
                        Log.d("aaaaaaaaaa", "loadEntities: 2")

                        // Loading state is handled by launchWithLoading
                    }

                    is Resource.Err -> {
                        Log.d("aaaaaaaaaa", "loadEntities: 3")


                    }
                }
            }
        }
    }

    fun refreshData() {
        launchWithLoading {
            // Call repository to refresh data
            // Example implementation:
            // repository.refreshEntities()

            emitUiEvent(HomeUIEvent.ShowRefreshMessage)
        }
    }

    fun onEntityClicked(entityId: String) {
        emitUiEvent(HomeUIEvent.NavigateToEntityDetail(entityId))
    }
}