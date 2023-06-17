package com.cheesecake.presentation.screens.search

import com.cheesecake.domain.entity.League

data class LeagueSearchUIState(
    val typeName: String = "Unknown",
    val imageUrl: String = "",
    val leagueName: String = "Unknown",
    val countryName: String = "Unknown",
    val onclick: () -> Unit = {},
)

fun League.toUIState(onclick: () -> Unit): LeagueSearchUIState {
    return LeagueSearchUIState(
        typeName = this.typeName,
        imageUrl = this.imageUrl,
        leagueName = this.name,
        countryName = country,
        onclick = onclick
    )
}
