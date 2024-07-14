package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.RecentSearch
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class ManageRecentSearchUseCase @Inject constructor(
    private val repository: IFootballRepository
) {
    suspend fun addOrUpdateRecentSearch(recent: RecentSearch) {
        val list = repository.getRecentSearches().firstOrNull()
        if (list?.any { it.id == recent.id } == true) {
            repository.deleteRecentSearchById(recent.id)
        }
        repository.updateOrInsertRecentSearch(recent)
    }

    /**
     * @author Shehab
     * */
    fun getRecentSearches(): Flow<List<RecentSearch>> {
        return repository.getRecentSearches()
    }

    /**
     * @author Shehab
     * */
    suspend fun deleteRecentSearchById(recentId: Int) {
        repository.deleteRecentSearchById(recentId)
    }

    /**
     * @author Shehab
     * */
    suspend fun deleteRecentSearches() {
        repository.deleteRecentSearches()
    }
}