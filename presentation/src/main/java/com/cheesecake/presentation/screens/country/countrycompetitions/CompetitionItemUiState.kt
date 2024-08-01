package com.cheesecake.presentation.screens.country.countrycompetitions

import com.cheesecake.domain.entity.League

data class CompetitionItemUiState(
    val competitionName: String = "",
    val imageUrl: String = "",
    val seasonStartEndYear: String = "",
    val onCompetitionClick: () -> Unit
)

fun League.toLeagueUIState(onLeagueClick: () -> Unit): CompetitionItemUiState =
    CompetitionItemUiState(
        this.name,
        this.imageUrl,
        "${this.seasonStartYear}/${this.seasonEndYear}",
        onLeagueClick
    )