package com.base.base_source.ui.home.states

import com.base.base_source.domain.model.Feed
import com.base.base_source.ui.base.ComponentState
import com.fpl.base.interfaces.ViewModelState
import com.fpl.base.interfaces.ViewState


class HomeViewStates {
    data class HomeViewState(
        val listFeed: ComponentState<List<Feed>> = ComponentState.Loading(),
    ) : ViewState()

    data class HomeViewModelState(
        val listFeed: ComponentState<List<Feed>> = ComponentState.Loading(),
    ) : ViewModelState() {

        override fun toUiState(): ViewState {
            return HomeViewState(
                listFeed = listFeed,
            )
        }
    }
}