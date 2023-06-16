package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.League
import com.cheesecake.domain.repository.IFootballRepository
import java.util.Date
import javax.inject.Inject

class GetFavoriteLeaguesMatchesByDateUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
    private val getFavoriteLeaguesUseCase: GetFavoriteLeaguesUseCase
) {

    suspend operator fun invoke(
        data: Date,
        timeZone: String,
        Season: Int
    ): List<Pair<League, List<Fixture>>> {
        val favLeague = getFavoriteLeaguesUseCase()

        footballRepository.getMatchesByLeagueIdAndSeason(timeZone, leagueId, Season)
            .groupBy { it.matchDate }.toList().reversed()
    }

}