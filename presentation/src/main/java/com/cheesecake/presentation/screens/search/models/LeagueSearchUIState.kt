package com.cheesecake.presentation.screens.search.models

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.entity.RecentSearch
import com.cheesecake.domain.entity.RecentSearchType

data class LeagueSearchUIState(
    val leagueTypeName: String = "Unknown",
    val imageUrl: String = "",
    val leagueName: String = "Unknown",
    val countryName: String = "Unknown",
    val season: Int = 0,
    val leagueId: Int = 0,
    val onclick: () -> Unit = {},
    val leagueCount: Int = 0
)

data class RecentSearchUIState(
    val title: String = "",
    val imageUrl: String = "",
    val type: RecentSearchType = RecentSearchType.UNKNOWN,
    val onclick: () -> Unit = {}
)

fun List<League>.toSearchUIState(onclick: (League) -> Unit): List<LeagueSearchUIState> {
    return map {
        LeagueSearchUIState(
            leagueTypeName = it.leagueTypeName,
            imageUrl = it.imageUrl,
            leagueName = it.name,
            countryName = it.countryName,
            onclick = { onclick(it) },
            season = it.season.toInt(),
            leagueId = it.leagueId,
            leagueCount = size
        )
    }
}

fun League.toRecentSearch() = RecentSearch(
    id = this.leagueId,
    title = this.name,
    imageUrl = this.imageUrl,
    type = RecentSearchType.LEAGUE,
)

fun RecentSearch.toUIState(onclick: (Int) -> Unit): RecentSearchUIState = RecentSearchUIState(
    title = title,
    imageUrl = imageUrl,
    type = type,
    onclick = { onclick(id) }
)
