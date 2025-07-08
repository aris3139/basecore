package com.base.base_source.domain.usecase

/**
 * Base UseCase interface for use cases that don't require parameters
 */
interface BaseUseCase<out T> {
    suspend operator fun invoke(): T
}

/**
 * Base UseCase interface for use cases that require parameters
 */
interface UseCaseWithParams<out T, in P> {
    suspend operator fun invoke(params: P): T
}
