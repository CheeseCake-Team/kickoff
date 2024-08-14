package com.cheesecake.presentation.screens.match.lineup

import com.cheesecake.domain.entity.FixtureLineup
import com.cheesecake.domain.entity.PlayerLineup

data class MatchLineupUiState(
    val teams: List<TeamData> = emptyList(),
    val data: TeamsLineups = TeamsLineups(),
    val noData: Boolean = false
)

data class TeamsLineups(
    val homeTeamLineup: TeamData = TeamData(),
    val awayTeamLineup: TeamData = TeamData(),
    val homeTeamSubstitutesPlayers: List<PlayerItemUiState> = emptyList(),
    val awayTeamSubstitutesPlayers: List<PlayerItemUiState> = emptyList()
)

data class TeamData(
    val teamName: String = "",
    val teamLogoUrl: String = "",
    val coachName: String = "",
    val formation: String = "",
    val playerItemUiState: List<PlayerItemUiState> = emptyList(),
    val substitutesPlayers: List<PlayerItemUiState> = emptyList()
)

data class PlayerItemUiState(
    val playerName: String = "",
    val playerNumber: Int = 0,
    val playerPosition: String = ""
)

fun List<FixtureLineup>.toUIState(): TeamsLineups {
    return TeamsLineups(
        homeTeamLineup = firstOrNull()?.toUIState()?: TeamData(),
        awayTeamLineup = lastOrNull()?.toUIState() ?: TeamData(),
        homeTeamSubstitutesPlayers = firstOrNull()?.substitutesPlayers?.toUIState() ?: emptyList(),
        awayTeamSubstitutesPlayers = lastOrNull()?.substitutesPlayers?.toUIState() ?: emptyList()
    )
}

fun List<FixtureLineup>.toTeamsUIState(): List<TeamData> {
    return map {
        TeamData(
            teamName = it.teamName,
            teamLogoUrl = it.teamLogoUrl,
            coachName = it.coachName,
            formation = it.formation,
            playerItemUiState = it.playerLineup.toUIState(),
            substitutesPlayers = it.substitutesPlayers.toUIState()

        )
    }
}


fun FixtureLineup.toUIState(): TeamData {
    return TeamData(
        teamName = teamName,
        teamLogoUrl = teamLogoUrl,
        coachName = coachName,
        formation = formation,
        playerItemUiState = playerLineup.toUIState(),
        substitutesPlayers = substitutesPlayers.toUIState(),
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



