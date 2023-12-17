package com.cheesecake.presentation.screens.team.teamPlayers

data class SquadPlayerItemUiState(
    val name: String,
    val imageUrl: String,
    val number: String,
    val onClick: () -> Unit
)