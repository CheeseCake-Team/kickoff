package com.cheesecake.presentation.screens.standings

import com.cheesecake.domain.entity.TeamStanding

@JvmName("teamStandingToTeamStandingItemUiState")
fun TeamStanding.toUiState(): TeamStandingItemUiState =
    TeamStandingItemUiState(
        form = form,
        rank = rank.toString(),
        name = name,
        imageUrl = logo,
        played = String.format("%02d", played),
        won = String.format("%02d", won),
        draw = String.format("%02d", draw),
        lose = String.format("%02d", lose),
        points = String.format("%02d", points),
        goalsForAgainst = goalsForAgainst
    )

@JvmName("teamsStandingToTeamsStandingItemUiState")
fun List<TeamStanding>.toUiState(): List<TeamStandingItemUiState> = this.map { it.toUiState() }