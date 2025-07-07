package com.base.base_source.domain.usecase

import com.base.base_source.domain.model.User
import com.base.base_source.domain.repository.UserRepository
import com.base.base_source.utils.Resource
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GetUsersUseCaseTest {

    @Mock
    private lateinit var userRepository: UserRepository

    private lateinit var getUsersUseCase: GetUsersUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        getUsersUseCase = GetUsersUseCase(userRepository)
    }

    @Test
    fun `invoke should return success when repository returns success`() = runTest {
        // Given
        val users = listOf(
            User(1, "John", "Doe", "Male", "john@example.com", "192.168.1.1")
        )
        whenever(userRepository.getUsers()).thenReturn(
            flowOf(Resource.Success(users))
        )

        // When
        val result = getUsersUseCase().first()

        // Then
        assertTrue(result is Resource.Success)
        assertEquals(users, result.data)
    }

    @Test
    fun `invoke should return error when repository returns error`() = runTest {
        // Given
        val errorMessage = "Network error"
        whenever(userRepository.getUsers()).thenReturn(
            flowOf(Resource.Err(errorMessage, null))
        )

        // When
        val result = getUsersUseCase().first()

        // Then
        assertTrue(result is Resource.Err)
        assertEquals(errorMessage, result.message)
    }
}