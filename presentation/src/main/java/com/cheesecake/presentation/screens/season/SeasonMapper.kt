package com.cheesecake.presentation.screens.season

@JvmName("seasonsToSeasonItemsUiState")
fun List<String>.toUiState(selectedSeason: String, onSeasonClicked: (String) -> Unit): List<SeasonItemUiState> {
    return this.map { season ->
        SeasonItemUiState(season =  season, isSelected = season == selectedSeason, onClicked = {
            onSeasonClicked(season)
        })
    }
}