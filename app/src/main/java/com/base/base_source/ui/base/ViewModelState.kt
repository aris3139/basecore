package com.fpl.base.interfaces

/**
 * Created by FPL on 21/01/2025.
 */

abstract class ViewModelState {
    abstract fun toUiState(): ViewState
}