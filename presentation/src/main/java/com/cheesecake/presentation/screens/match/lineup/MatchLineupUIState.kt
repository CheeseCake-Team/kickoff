package com.cheesecake.presentation.screens.match.lineup

import com.cheesecake.domain.entity.FixtureLineup
import com.cheesecake.domain.entity.PlayerLineup

data class MatchLineupUIState(
    val errorMessage: String = "error",
    val isLoading: Boolean = true,
    val homeTeamLineup: FixtureLineupUiState,
    val awayTeamLineup: FixtureLineupUiState,

    )

data class FixtureLineupUiState(
    val formation: String,
    val playerItemUiState: List<PlayerItemUiState>

)

data class PlayerItemUiState(
    val playerName: String,
    val playerNumber: Int,
    val playerPosition: String
)





