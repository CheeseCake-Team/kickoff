package com.cheesecake.presentation.screens.team.teamPlayers

import com.cheesecake.presentation.screens.league.LeagueNavigationEvent

sealed interface TeamPLayerNavigationEvent {

    object NavigateBack: TeamPLayerNavigationEvent

    data class NavigateToPlayer(
        val playerId: Int
    ): TeamPLayerNavigationEvent
}