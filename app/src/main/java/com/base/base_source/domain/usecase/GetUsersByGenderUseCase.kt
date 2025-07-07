package com.base.base_source.domain.usecase

import com.base.base_source.domain.model.User
import com.base.base_source.domain.repository.UserRepository
import com.base.base_source.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetUsersByGenderUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(gender: String): Flow<Resource<List<User>>> = 
        userRepository.getUsers().map { result ->
            when (result) {
                is Resource.Success -> {
                    val filteredUsers = result.data?.filter { 
                        it.gender.equals(gender, ignoreCase = true) 
                    } ?: emptyList()
                    Resource.Success(filteredUsers)
                }
                is Resource.Err -> result
                is Resource.Loading -> result
            }
        }
}