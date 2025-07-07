package com.base.base_source.domain.repository

import com.base.base_source.domain.model.User
import com.base.base_source.utils.Resource
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(): Flow<Resource<List<User>>>
}