package com.cheesecake.presentation.screens.team.teamPlayers

data class SquadPlayerItemUIState(
    val name: String,
    val imageUrl: String,
    val number: Int,
    val onClick: () -> Unit
)