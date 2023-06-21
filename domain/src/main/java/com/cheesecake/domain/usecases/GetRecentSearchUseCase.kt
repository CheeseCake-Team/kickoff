package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.RecentSearch
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetRecentSearchUseCase @Inject constructor(
    private val footballRepository: IFootballRepository
) {

    suspend operator fun invoke(): List<RecentSearch> {
        return footballRepository.getRecentSearches()
    }

}

