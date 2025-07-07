package com.base.base_source.domain.usecase

import com.base.base_source.domain.model.User
import com.base.base_source.domain.repository.UserRepository
import com.base.base_source.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(): Flow<Resource<List<User>>> = userRepository.getUsers()
}