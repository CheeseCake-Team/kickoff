package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.repository.IFootballRepository
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject

class GetPairsOfMatchesAndDateByLeagueIdAndSeasonUseCase
@Inject constructor(private val footballRepository: IFootballRepository) {
    suspend operator fun invoke(
        timeZone: String,
        leagueId: Int,
        season: Int
    ): List<Pair<String, List<Fixture>>> {
        return footballRepository.getMatchesByLeagueIdAndSeason(timeZone, leagueId, season)
            .sortedBy { it.matchDate }
            .groupBy { it.matchDate.toStanderDateString() }
            .toList()
            .reversed()
    }

    fun Date.toStanderDateString(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        return dateFormat.format(this)
    }
}