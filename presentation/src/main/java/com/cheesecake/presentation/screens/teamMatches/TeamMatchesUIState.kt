package com.cheesecake.presentation.screens.teamMatches

import com.cheesecake.domain.entity.Fixture
import java.util.Date

data class TeamMatchesUIState(
    val data: List<Fixture> = emptyList(),
    val errorMessage: String = "",
    val isLoading: Boolean = true
)