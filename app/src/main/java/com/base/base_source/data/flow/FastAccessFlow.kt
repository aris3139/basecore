package com.base.base_source.data.flow

import com.base.base_source.data.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 */
class FastAccessFlow<Data, Domain>(
    private val localData: suspend () -> Resource<Data>,
    private val dataFromServer: suspend () -> Resource<Data>,
    private val convertDataToDomain: suspend (Resource<Data>) -> Resource<Domain>
) : IFlow<Domain> {

    override fun execute(): Flow<Resource<Domain>> = flow {
        emit(Resource.Loading)
        val localResult = localData()
        if (localResult is Resource.Success) {
            emit(convertDataToDomain(localResult))
        } else {
            val serverResult = dataFromServer()
            emit(convertDataToDomain(serverResult))
        }
    }
}