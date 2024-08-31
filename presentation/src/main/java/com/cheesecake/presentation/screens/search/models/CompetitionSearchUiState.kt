package com.cheesecake.presentation.screens.search.models

import com.cheesecake.domain.entity.League

data class CompetitionSearchUiState(
    val leagueTypeName: String = "Unknown",
    val imageUrl: String = "",
    val leagueName: String = "Unknown",
    val countryName: String = "Unknown",
    val season: Int = 0,
    val leagueId: Int = 0,
    val onclick: () -> Unit = {},
    val leagueCount: Int = 0
)

fun List<League>.toSearchUIState(onclick: (League) -> Unit): List<CompetitionSearchUiState> {
    return map {
        CompetitionSearchUiState(
            leagueTypeName = it.leagueTypeName,
            imageUrl = it.imageUrl,
            leagueName = it.name,
            countryName = it.countryName,
            onclick = { onclick(it) },
            season = it.season.last(),
            leagueId = it.competitionId,
            leagueCount = size
        )
    }
}


