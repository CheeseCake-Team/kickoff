package com.cheesecake.presentation.screens.match.lineup

import com.cheesecake.domain.entity.FixtureLineup
import com.cheesecake.domain.entity.PlayerLineup

data class MatchLineupUIState(
    val errorMessage: String = "error",
    val isLoading: Boolean = true,
    val data: TeamsLineups = TeamsLineups(),
)

data class TeamsLineups(
    val homeTeamLineup: FixtureLineupUiState = FixtureLineupUiState(),
    val awayTeamLineup: FixtureLineupUiState = FixtureLineupUiState(),
    val homeTeamSubstitutesPlayers: List<PlayerItemUiState> = emptyList(),
    val awayTeamSubstitutesPlayers: List<PlayerItemUiState> = emptyList()
)

data class FixtureLineupUiState(
    val teamName: String = "",
    val teamLogoUrl: String = "",
    val coachName: String = "",
    val formation: String = "",
    val playerItemUiState: List<PlayerItemUiState> = emptyList()
)

data class PlayerItemUiState(
    val playerName: String = "",
    val playerNumber: Int = 0,
    val playerPosition: String = ""
)

fun List<FixtureLineup>.toUIState(): TeamsLineups {
    return TeamsLineups(
        homeTeamLineup = first().toUIState(),
        awayTeamLineup = last().toUIState(),
        homeTeamSubstitutesPlayers = first().substitutesPlayers.toUIState(),
        awayTeamSubstitutesPlayers = last().substitutesPlayers.toUIState()
    )
}


fun FixtureLineup.toUIState(): FixtureLineupUiState {
    return FixtureLineupUiState(
        teamName = teamName,
        teamLogoUrl = teamLogoUrl,
        coachName = coachName,
        formation = formation,
        playerItemUiState = playerLineup.toUIState()
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



