package com.cheesecake.presentation.screens.team.teamstatistics

import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.entity.TeamStatisticsEntity

data class TeamStatisticsUIState(
    val form: List<String> = emptyList(),
    val homePlayed: Int = 0,
    val homeWins: Int = 0,
    val homeLoses: Int = 0,
    val homeCleanSheet: Int = 0,
    val homeFailed: Int = 0,
    val homeGoalsFor: Int = 0,
    val homeGoalsAgainst: Int = 0,

    val awayPlayed: Int = 0,
    val awayWins: Int = 0,
    val awayLoses: Int = 0,
    val awayCleanSheet: Int = 0,
    val awayFailed: Int = 0,
    val awayGoalsFor: Int = 0,
    val awayGoalsAgainst: Int = 0,

    val totalPlayed: Int = 0,
    val totalWins: Int = 0,
    val totalLoses: Int = 0,
    val totalCleanSheet: Int = 0,
    val totalFailed: Int = 0,
    val totalGoalsFor: Int = 0,
    val totalGoalsAgainst: Int = 0,
    val isLoading: Boolean = true,

    val data: List<Team> = emptyList(),
    val errorMessage: String = "Error"
)

fun TeamStatisticsEntity.toUIState(): TeamStatisticsUIState {
    return TeamStatisticsUIState(
        form = form,
        homePlayed = played.home,
        homeWins = wins.home,
        homeLoses = loses.home,
        homeCleanSheet = cleanSheet.home,
        homeFailed = failedToScore.home,
        homeGoalsFor = goalsFor.home,
        homeGoalsAgainst = goalsAgainst.home,
        awayPlayed = played.away,
        awayWins = wins.away,
        awayLoses = loses.away,
        awayCleanSheet = cleanSheet.away,
        awayFailed = failedToScore.away,
        awayGoalsFor = goalsFor.away,
        awayGoalsAgainst = goalsAgainst.away,
        totalPlayed = played.total,
        totalWins = wins.total,
        totalLoses = loses.total,
        totalCleanSheet = cleanSheet.total,
        totalFailed = failedToScore.total,
        totalGoalsFor = goalsFor.total,
        totalGoalsAgainst = goalsAgainst.total
    )
}
