package com.cheesecake.presentation.screens.team.teamPlayers

sealed interface TeamPLayerNavigationEvent {

    object NavigateBack: TeamPLayerNavigationEvent

    data class NavigateToPlayer(
        val playerId: Int
    ): TeamPLayerNavigationEvent
}