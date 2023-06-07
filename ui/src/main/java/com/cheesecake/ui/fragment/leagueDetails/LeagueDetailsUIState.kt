package com.cheesecake.ui.fragment.leagueDetails

import com.cheesecake.domain.entity.TeamStandingEntity

data class LeagueDetailsUIState(
    val country: String = "",
    val round: String = "",
    val teamsCount: String = "",
    val teamsStanding: List<TeamStandingEntity> = emptyList(),
    val topPlayers: List<Any> = emptyList(),
    val isLoading: Boolean = true,
    val ErrorMessage: Boolean = true
)
