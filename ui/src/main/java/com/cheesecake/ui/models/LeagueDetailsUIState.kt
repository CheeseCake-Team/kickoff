package com.cheesecake.ui.models

import com.cheesecake.domain.entity.PlayerStatisticsEntity
import com.cheesecake.domain.entity.TeamStandingEntity

data class LeagueDetailsUIState(
    val country: String = "",
    val round: String = "",
    val teamsCount: String = "",
    val teamsStanding: List<TeamStandingEntity> = emptyList(),
    val topPlayers: List<PlayerStatisticsEntity> = emptyList(),
    val isLoading: Boolean = true,
    val ErrorMessage: Boolean = true
)
