package com.base.base_source.domain.usecase

import com.base.base_source.domain.model.DomainEntity
import com.base.base_source.domain.repository.EntityRepository
import com.base.base_source.utils.Resource
import javax.inject.Inject

class GetEntityByIdUseCase @Inject constructor(
    private val repository: EntityRepository
) {
    suspend operator fun invoke(id: Int): Resource<DomainEntity> {
        return repository.getEntityById(id)
    }
}