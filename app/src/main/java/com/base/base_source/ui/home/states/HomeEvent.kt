package com.base.base_source.ui.home.states

import com.fpl.base.interfaces.ViewEvent

sealed class HomeEvent : ViewEvent {
    data class RefreshData(val deleteKey: String) : HomeEvent()
}
