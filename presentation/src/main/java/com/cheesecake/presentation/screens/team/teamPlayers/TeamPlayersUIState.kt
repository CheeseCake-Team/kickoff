package com.cheesecake.presentation.screens.team.teamPlayers

import com.cheesecake.domain.entity.SquadPlayer

data class TeamPlayersUIState(
    val data: List<Pair<String, List<SquadPlayer>>> = emptyList(),
    val errorMessage: String = "",
    val isLoading: Boolean = true
)
