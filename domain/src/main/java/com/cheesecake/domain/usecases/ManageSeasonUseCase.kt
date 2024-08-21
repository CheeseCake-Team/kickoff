package com.cheesecake.domain.usecases

import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ManageSeasonUseCase @Inject constructor(
    private val repository: IFootballRepository
) {

    fun getSeason(): Flow<String> = repository.getSeason()

    suspend fun setSeason(season: String) {
        repository.setSeason(season)
    }
}