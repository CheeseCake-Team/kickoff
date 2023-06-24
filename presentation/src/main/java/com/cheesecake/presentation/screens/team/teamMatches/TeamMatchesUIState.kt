package com.cheesecake.presentation.screens.team.teamMatches

import com.cheesecake.domain.entity.Fixture

data class TeamMatchesUIState(
    val data: List<Fixture> = emptyList(),
    val errorMessage: String = "",
    val isLoading: Boolean = true
)


data class MatchItemUIState(
    val homeTeamName: String = "",
    val homeTeamLogoUrl: String = "",
    val homeTeamGoals: Int = 0,
    val awayTeamName: String = "",
    val awayTeamLogoUrl: String = "",
    val awayTeamGoals: Int = 0,
    val isFinished: Boolean = false,
    val matchTime: String = "",
    val onclick: () -> Unit = {}
)