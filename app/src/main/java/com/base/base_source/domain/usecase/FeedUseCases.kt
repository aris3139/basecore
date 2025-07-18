package com.base.base_source.domain.usecase

import com.base.base_source.data.Resource
import com.base.base_source.domain.model.Feed
import com.base.base_source.domain.repository.FeedRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case for fetching entities from the repository
 */
class GetFeedsUseCase @Inject constructor(
    private val repository: FeedRepository
) : BaseUseCase<Flow<Resource<List<Feed>>>> {
    override suspend fun invoke(): Flow<Resource<List<Feed>>> {
        return repository.getFeeds()
    }
}
