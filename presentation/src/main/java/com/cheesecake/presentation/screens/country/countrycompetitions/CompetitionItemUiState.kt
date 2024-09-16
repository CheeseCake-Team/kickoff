package com.cheesecake.presentation.screens.country.countrycompetitions

import com.cheesecake.domain.entity.Competition

data class CompetitionItemUiState(
    val competitionName: String = "",
    val imageUrl: String = "",
    val seasonStartEndYear: String = "",
    val onCompetitionClick: () -> Unit
)

fun Competition.toCompetitionUIState(onLeagueClick: () -> Unit): CompetitionItemUiState =
    CompetitionItemUiState(
        this.name,
        this.imageUrl,
        "${this.seasonStartYear}/${this.seasonEndYear}",
        onLeagueClick
    )