package com.base.base_source.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.base.base_source.domain.model.DomainEntity
import com.base.base_source.domain.usecase.GetEntitiesUseCase
import com.base.base_source.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val getEntitiesUseCase: GetEntitiesUseCase
) : ViewModel() {
    private val _entities = MutableStateFlow<Resource<List<DomainEntity>>>(Resource.Loading())
    val entities: StateFlow<Resource<List<DomainEntity>>> = _entities

    init {
        loadEntities()
    }

    private fun loadEntities() {
        viewModelScope.launch {
            getEntitiesUseCase().collect { data ->
                _entities.value = data
            }
        }
    }
}