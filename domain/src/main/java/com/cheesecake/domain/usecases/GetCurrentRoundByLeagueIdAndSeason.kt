package com.cheesecake.domain.usecases

import com.cheesecake.domain.repository.IFootballRepository
import javax.inject.Inject

class GetCurrentRoundByLeagueIdAndSeason @Inject constructor(
    private val footballRepository: IFootballRepository
) {

    suspend operator fun invoke(leagueId: Int, season: Int): String {
        return footballRepository.getCurrentRoundByIdAndSeason(leagueId, season)
            ?: "This league is Finished."
    }

}