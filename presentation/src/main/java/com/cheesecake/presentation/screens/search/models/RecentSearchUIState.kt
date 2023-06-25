package com.cheesecake.presentation.screens.search.models

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.entity.RecentSearch
import com.cheesecake.domain.entity.RecentSearchType
import com.cheesecake.domain.entity.Team

data class RecentSearchUIState(
    val title: String = "",
    val imageUrl: String = "",
    val type: RecentSearchType = RecentSearchType.UNKNOWN,
    val onclick: () -> Unit = {}
)

fun RecentSearch.toUIState(onclick: (Int) -> Unit): RecentSearchUIState = RecentSearchUIState(
    title = title,
    imageUrl = imageUrl,
    type = type,
    onclick = { onclick(id) }
)

fun League.toRecentSearch() = RecentSearch(
    id = this.leagueId,
    title = this.name,
    imageUrl = this.imageUrl,
    type = RecentSearchType.LEAGUE,
)

fun Team.toRecentSearch() = RecentSearch(
    id = this.id,
    title = this.name,
    imageUrl = this.imageUrl,
    type = RecentSearchType.TEAM,
)

