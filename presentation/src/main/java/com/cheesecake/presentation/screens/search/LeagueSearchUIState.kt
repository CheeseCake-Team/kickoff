package com.cheesecake.presentation.screens.search

import com.cheesecake.domain.entity.League

data class LeagueSearchUIState(
    val leagueTypeName: String = "Unknown",
    val imageUrl: String = "",
    val leagueName: String = "Unknown",
    val countryName: String = "Unknown",
    val season: Int = 0,
    val leagueId: Int = 0,
    val onclick: (Int,Int) -> Unit,
    val leagueCount: Int = 0
)

fun League.toSearchUIState(onclick: (id: Int, season: Int) -> Unit): LeagueSearchUIState {
    return LeagueSearchUIState(
        leagueTypeName = this.leagueTypeName,
        imageUrl = this.imageUrl,
        leagueName = this.name,
        countryName = this.countryName,
        onclick =  { id, season -> onclick(id, season) },
        season = this.season.toInt(),
        leagueId = this.leagueId,
        leagueCount = this.leagueCount
    )
}



