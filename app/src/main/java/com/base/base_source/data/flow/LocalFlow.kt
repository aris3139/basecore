package com.base.base_source.data.flow

import com.base.base_source.data.Resource
import kotlinx.coroutines.flow.flow

class LocalFlow<Data, Domain>(
    val localData: suspend () -> Resource<Data>,
    val convertDataToDomain: suspend (Resource<Data>) -> Resource<Domain>
) : IFlow<Domain> {

    override fun execute() = flow {
        emit(Resource.Loading)
        val localResult = localData()
        val domainResult = convertDataToDomain(localResult)
        emit(domainResult)
    }
}