package com.cheesecake.presentation.screens.match.lineup

import com.cheesecake.domain.entity.FixtureLineup
import com.cheesecake.domain.entity.PlayerLineup

data class MatchLineupUIState(
    val errorMessage: String = "error",
    val isLoading: Boolean = true,
    val data: HomeAwayTeams = HomeAwayTeams()

)

data class HomeAwayTeams(
    val homeTeamLineup: FixtureLineupUiState = FixtureLineupUiState(),
    val awayTeamLineup: FixtureLineupUiState = FixtureLineupUiState(),
)

data class FixtureLineupUiState(
    val formation: String = "",
    val playerItemUiState: List<PlayerItemUiState> = emptyList()
)

data class PlayerItemUiState(
    val playerName: String = "",
    val playerNumber: Int = 0,
    val playerPosition: String = ""
)

fun List<FixtureLineup>.toUIState(): HomeAwayTeams {
    return HomeAwayTeams(
        homeTeamLineup = first().toUIState(),
        awayTeamLineup = last().toUIState()
    )
}


fun FixtureLineup.toUIState(): FixtureLineupUiState {
    return FixtureLineupUiState(
        formation = formation, playerItemUiState = playerLineup.toUIState()
    )
}

fun List<PlayerLineup>.toUIState(): List<PlayerItemUiState> {
    return map {
        PlayerItemUiState(
            playerName = it.playerName,
            playerNumber = it.playerNumber,
            playerPosition = it.playerPosition
        )
    }
}



