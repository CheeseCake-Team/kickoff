package com.cheesecake.presentation.screens.teamMatches

import com.cheesecake.domain.entity.Fixture

data class TeamMatchesUIState(
    val data: List<Pair<String, List<Fixture>>> = emptyList(),
    val errorMessage: String = "",
    val isLoading: Boolean = true
)