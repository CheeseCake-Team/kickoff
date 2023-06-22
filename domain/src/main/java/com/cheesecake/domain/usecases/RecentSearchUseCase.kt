package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.RecentSearch
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecentSearchUseCase @Inject constructor(
    private val repository: IFootballRepository
) {

    fun getRecentSearch(): Flow<List<RecentSearch>> {
        return repository.getRecentSearches()
    }

    suspend fun deleteRecentSearchById(recentId: Int) {
        repository.deleteRecentSearchById(recentId)
    }

    suspend fun deleteRecentSearches() {
        repository.deleteRecentSearches()
    }

}

