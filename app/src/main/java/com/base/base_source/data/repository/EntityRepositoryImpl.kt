package com.base.base_source.data.repository

import com.base.base_source.data.local.EntityDao
import com.base.base_source.data.mapper.EntityMapper
import com.base.base_source.data.remote.EntityRemoteDataSource
import com.base.base_source.domain.model.DomainEntity
import com.base.base_source.domain.repository.EntityRepository
import com.base.base_source.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class EntityRepositoryImpl @Inject constructor(
    private val remoteDataSource: EntityRemoteDataSource,
    private val dao: EntityDao
) : EntityRepository {

    override fun getEntitiesAsFlow(): Flow<Resource<List<DomainEntity>>> = flow {
        emit(Resource.Loading())
        when (val result = remoteDataSource.getAllData()) {
            is Resource.Success -> {
                result.data?.let { dao.insertAll(it) }
                emitAll(dao.getAllEntities().map { entities -> 
                    Resource.Success(EntityMapper.mapToDomainList(entities))
                })
            }

            is Resource.Err -> {
                emit(Resource.Err(result.message!!, null))
                emitAll(dao.getAllEntities().map { entities -> 
                    Resource.Success(EntityMapper.mapToDomainList(entities))
                })
            }

            else -> emit(Resource.Loading())
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getEntityById(id: Int): Resource<DomainEntity> {
        return when (val result = remoteDataSource.getDataForId(id)) {
            is Resource.Success -> {
                result.data?.let { entity ->
                    Resource.Success(EntityMapper.mapToDomain(entity))
                } ?: Resource.Err("Entity not found")
            }
            is Resource.Err -> Resource.Err(result.message!!)
            else -> Resource.Loading()
        }
    }
}