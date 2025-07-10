package com.base.base_source.ui.home

import androidx.lifecycle.viewModelScope
import com.base.base_source.data.Resource
import com.base.base_source.domain.usecase.GetFeedsUseCase
import com.base.base_source.ui.base.BaseViewModel
import com.base.base_source.ui.base.ComponentState
import com.base.base_source.ui.home.states.HomeEvent
import com.base.base_source.ui.home.states.HomeViewStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getFeedsUseCase: GetFeedsUseCase,
) : BaseViewModel<HomeEvent,
        HomeViewStates.HomeViewState,
        HomeViewStates.HomeViewModelState>(
    initState = HomeViewStates.HomeViewModelState()
) {
    init {
        getFeeds()
    }

    override fun onTriggerEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.RefreshData -> {

            }
        }
    }

    private fun getFeeds() {
        viewModelScope.launch {
            getFeedsUseCase.invoke().collect { resource ->
                when (resource) {
                    is Resource.Error -> {
                        viewModelState.update {
                            it.copy(
                                listFeed = ComponentState.Error(
                                    error = resource.message
                                )
                            )
                        }
                    }

                    is Resource.Loading -> {

                    }

                    is Resource.Success -> {
                        viewModelState.update {
                            it.copy(listFeed = ComponentState.Success(data = resource.data))
                        }
                    }
                }
            }
        }

    }
}

