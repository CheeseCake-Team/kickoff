package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteLeaguesUseCase @Inject constructor(
    private val repository: IFootballRepository
) {

    suspend operator fun invoke(): Flow<List<League>> =
        repository.getFavoriteLeagues()

}