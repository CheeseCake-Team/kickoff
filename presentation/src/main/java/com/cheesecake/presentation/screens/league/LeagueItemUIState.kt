package com.cheesecake.presentation.screens.league

import com.cheesecake.domain.entity.League

data class LeagueItemUIState(
    val leagueName: String = "",
    val imageUrl: String = "",
    val seasonStartEndYear: String = "",
    val onLeagueClick: () -> Unit
)

fun League.toLeagueUIState(onLeagueClick: () -> Unit): LeagueItemUIState =
    LeagueItemUIState(
        this.name,
        this.imageUrl,
        "${this.seasonStartYear}/${this.seasonEndYear}",
        onLeagueClick
    )