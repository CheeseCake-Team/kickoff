package com.cheesecake.presentation.ui.search

import com.cheesecake.domain.entity.League

data class LeagueSearchUIState(
    val typeName: String = "Unknown",
    val imageUrl: String = "",
    val leagueName: String = "Unknown",
    val countryName: String = "Unknown"
)

fun League.toUIState(): LeagueSearchUIState {
    return LeagueSearchUIState(
        typeName = this.typeName,
        imageUrl = this.imageUrl,
        leagueName = this.name,
        countryName = country
    )
}
