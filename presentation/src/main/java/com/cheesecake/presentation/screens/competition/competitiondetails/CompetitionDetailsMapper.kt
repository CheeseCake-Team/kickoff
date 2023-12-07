package com.cheesecake.presentation.screens.competition.competitiondetails

import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.entity.TeamStanding

@JvmName("teamStandingToTeamStandingItemUiState")
fun TeamStanding.toUiState(): TeamStandingItemUiState =
    TeamStandingItemUiState(
        imageUrl = this.logo,
        name = this.name,
        won = this.won.toString(),
        lose = this.lose.toString(),
        draw = this.lose.toString(),
        played = this.played.toString(),
        points = this.points.toString()
    )

@JvmName("teamsStandingToTeamStandingItemsUiState")
fun List<TeamStanding>.toUiState(): List<TeamStandingItemUiState> = this.map { it.toUiState() }

@JvmName("playerStatisticsToPlayerStatisticsItemUiState")
fun PlayerStatistics.toUiState(): PlayerStatisticsItemUiState =
    PlayerStatisticsItemUiState(
        imageUrl = this.imageUrl,
        name = this.name,
        goals = this.goals.toString()
    )

@JvmName("playersStatisticsToPlayerStatisticsItemsUiState")
fun List<PlayerStatistics>.toUiState(): List<PlayerStatisticsItemUiState> =
    this.map { it.toUiState() }