package com.cheesecake.domain.usecases

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.Competition
import com.cheesecake.domain.entity.Match
import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Date
import javax.inject.Inject

class ManageMatchesUseCase @Inject constructor(
    private val footballRepository: IFootballRepository,
    private val dateManager: DateManager
) {
    /**
     * @author Mujtaba & Mahmoud
     * */
    suspend fun getMatchDetails(
        homeTeamId: Int,
        awayTeamId: Int,
        date: String,
        timeZone: String
    ): Match {
        return footballRepository.getMatchDetails(homeTeamId, awayTeamId, date, timeZone)
    }

    /**
     * @author Ali
     * */
    suspend fun getMatchStatisticsByMatchId(matchId: Int) =
        footballRepository.getMatchStatisticsByMatchId(matchId)

    /**
     * @author Mujtaba
     * */
    suspend fun getMatchLineupByMatchId(matchId: Int) =
        footballRepository.getMatchLineupByMatchId(matchId)

    /**
     * @author Mujtaba
     * */
    suspend fun getMatchEventByMatchId(matchId: Int) =
        footballRepository.getMatchEventByMatchId(matchId).reversed()

    /**
     * @author Mahmoud
     * */
    suspend fun getFavoriteCompetitionsMatches(
        date: Date,
        timeZone: String,
    ): Flow<List<Pair<Competition, List<Fixture>>>> {
        return footballRepository.getFavoriteCompetition().map { list ->
            list.map { league ->
                val matches = footballRepository.getMatchesByCompetitionIdAndSeason(
                    timeZone,
                    league.competitionId,
                    league.season.last()
                )
                    .filter { dateManager.isSameDay(it.matchDate, date) }
                league to matches
            }
        }
    }

    /**
     * @author Mahmoud & Ali
     * */
    suspend fun fetchAndGroupMatchesByDate(
        timeZone: String,
        leagueId: Int,
        season: Int
    ): List<Pair<String, List<Fixture>>> {
        return footballRepository.getMatchesByCompetitionIdAndSeason(timeZone, leagueId, season)
            .sortedBy { it.matchDate }
            .groupBy { dateManager.toStanderDateString(it.matchDate) }
            .toList()
            .reversed()
    }

    /**
     * @author Nahla & Ali & Abdurrahman
     * */
    suspend fun getTeamMatchesByTeamIdAndSeason(
        timeZone: String,
        teamId: Int,
        season: Int
    ): List<Fixture> {
        return footballRepository.getTeamMatchesByTeamIdAndSeason(timeZone, season, teamId)
            .sortedByDescending { it.matchDate }
            .toList()
    }

    /**
     * @author Hassan
     * */
    suspend fun getMatchesByCompetitionIdAndSeason(
        timezone: String,
        competitionId: Int,
        seasonId: Int
    ): List<Fixture> {
        return footballRepository.getMatchesByCompetitionIdAndSeason(
            timezone,
            competitionId,
            seasonId
        )
    }
}