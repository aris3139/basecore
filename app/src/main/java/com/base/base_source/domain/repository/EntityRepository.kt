package com.base.base_source.domain.repository

import com.base.base_source.domain.model.DomainEntity
import com.base.base_source.utils.Resource
import kotlinx.coroutines.flow.Flow

interface EntityRepository {
    fun getEntitiesAsFlow(): Flow<Resource<List<DomainEntity>>>
    suspend fun getEntityById(id: Int): Resource<DomainEntity>
}