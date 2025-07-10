package com.base.base_source.data.flow

import com.base.base_source.data.Resource
import kotlinx.coroutines.flow.flow

class ServerFlow<Data, Domain>(
    val dataFromServer: suspend () -> Resource<Data>,
    val convertDataToDomain: suspend (Resource<Data>) -> Resource<Domain>
) : IFlow<Domain> {

    override fun execute() = flow {
        emit(Resource.Loading)
        val serverResult = dataFromServer()
        val domainResult = convertDataToDomain(serverResult)
        emit(domainResult)
    }
}