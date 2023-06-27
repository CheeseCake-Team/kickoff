package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetLeagueByIdAndSeasonUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
) {

    suspend operator fun invoke(leagueId: Int,): League {
        return footballRepository.getLocallyLeagueByIdAndSeason(leagueId, )
            ?: footballRepository.getRemotelyLeagueByIdAndSeason(leagueId, )
    }

}