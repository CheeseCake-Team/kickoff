package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.RecentSearch
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class SaveRecentSearchUseCase @Inject constructor(
    private val repository: IFootballRepository
) {
    suspend operator fun invoke(recent: RecentSearch) {
        val list = repository.getRecentSearches().firstOrNull()
        if (list?.any { it.id == recent.id } == true) {
            repository.deleteRecentSearchById(recent.id)
        }
        repository.updateOrInsertRecentSearch(recent)
    }



}