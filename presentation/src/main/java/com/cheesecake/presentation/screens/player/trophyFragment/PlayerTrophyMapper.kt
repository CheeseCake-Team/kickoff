package com.cheesecake.presentation.screens.player.trophyFragment

import com.cheesecake.domain.entity.Trophy

@JvmName("trophyToPlayerTrophyItemUiState")
fun Trophy.toUiState(): PlayerTrophyItemUiState =
    PlayerTrophyItemUiState(
        competitionName, country, place, season
    )

@JvmName("trophiesToPlayerTrophyItemsUiState")
fun List<Trophy>.toUiState(): List<PlayerTrophyItemUiState> = this.map { it.toUiState() }