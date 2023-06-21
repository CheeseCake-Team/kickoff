package com.cheesecake.presentation.screens.search.models

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

fun List<League>.toSearchUIState(onclick: (Int,Int) -> Unit): List<LeagueSearchUIState> {
    return map{
        LeagueSearchUIState(
            leagueTypeName = it.leagueTypeName,
            imageUrl = it.imageUrl,
            leagueName = it.name,
            countryName = it.countryName,
            onclick = onclick,
            season = it.season.toInt(),
            leagueId = it.leagueId,
            leagueCount = size
        )
    }
}



