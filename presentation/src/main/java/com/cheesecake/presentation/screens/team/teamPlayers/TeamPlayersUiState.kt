package com.cheesecake.presentation.screens.team.teamPlayers

data class TeamPlayersUiState(
    val data: List<Pair<String, List<SquadPlayerItemUiState>>> = emptyList(),
)