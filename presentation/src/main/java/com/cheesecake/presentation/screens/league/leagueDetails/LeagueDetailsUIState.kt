package com.cheesecake.presentation.screens.league.leagueDetails

import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.entity.TeamStanding

data class LeagueDetailsUIState(
    val country: String = "",
    val round: String = "",
    val teamsCount: String = "",
    val teamsStanding: List<TeamStanding> = emptyList(),
    val topPlayers: List<PlayerStatistics> = emptyList(),
    val isTopPlayersEmpty: Boolean = false,
    val isTeamsStandingEmpty: Boolean = false,
    val isLoading: Boolean = true,
    val onStandingSeeAllClick: () -> Unit = {},
    val onTopScorerClick: () -> Unit = {},
    val errorMessage: String = ""
)
