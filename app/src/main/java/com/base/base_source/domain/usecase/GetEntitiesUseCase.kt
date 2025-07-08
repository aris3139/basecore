package com.base.base_source.domain.usecase

import com.base.base_source.domain.model.DomainEntity
import com.base.base_source.domain.repository.EntityRepository
import com.base.base_source.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEntitiesUseCase @Inject constructor(
    private val repository: EntityRepository
) {
    operator fun invoke(): Flow<Resource<List<DomainEntity>>> {
        return repository.getEntitiesAsFlow()
    }
}