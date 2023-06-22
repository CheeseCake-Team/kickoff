package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.RecentSearch
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class SaveRecentSearchUseCase @Inject constructor(
    private val repository: IFootballRepository
) {
    suspend operator fun invoke(recent: RecentSearch) {
        repository.updateOrInsertRecentSearch(recent)
    }


}