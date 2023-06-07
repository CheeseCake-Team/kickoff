package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.LeagueEntity
import javax.inject.Inject

class GetLeagueByIdAndSeasonUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
) {

    suspend operator fun invoke(leagueId: Int, leagueSeason: Int): LeagueEntity? {
        return footballRepository.getLocallyLeagueByIdAndSeason(leagueId, leagueSeason)
            ?: footballRepository.getRemotelyLeagueByIdAndSeason(leagueId, leagueSeason)
    }

}