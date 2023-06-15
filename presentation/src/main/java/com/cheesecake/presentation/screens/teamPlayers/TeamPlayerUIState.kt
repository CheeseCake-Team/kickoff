package com.cheesecake.presentation.screens.teamPlayers

import com.cheesecake.domain.entity.SquadPlayer


data class TeamPlayerUIState(
    val data: List<Pair<String, List<SquadPlayer>>> = emptyList(),
    val errorMessage: String = "",
    val isLoading: Boolean = true
)