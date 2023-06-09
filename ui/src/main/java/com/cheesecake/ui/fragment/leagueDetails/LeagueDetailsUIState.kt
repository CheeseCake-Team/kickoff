package com.cheesecake.ui.fragment.leagueDetails

import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.entity.TeamStanding

data class LeagueDetailsUIState(
    val country: String = "",
    val round: String = "",
    val teamsCount: String = "",
    val teamsStanding: List<TeamStanding> = emptyList(),
    val topPlayers: List<PlayerStatistics> = emptyList(),
    val isLoading: Boolean = true,
    val ErrorMessage: Boolean = true
)
