package com.base.base_source.data.flow

import com.base.base_source.data.Resource
import kotlinx.coroutines.flow.Flow

interface IFlow<Type> {
    fun execute(): Flow<Resource<Type>>
}