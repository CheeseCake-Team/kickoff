package com.cheesecake.presentation.screens.home

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.League
import com.cheesecake.presentation.mapper.toMatchUIState

data class FavoriteHomeItemUIState(
    val title: String = "",
    val imageUrl: String = "",
    val leagueId: Int = 0,
    val season: Int = 0,
    val onclick: (leagueId: Int, season: Int) -> Unit = { _, _ -> },
    val matches: List<MatchItemUIState> = emptyList(),
)

fun List<Pair<League, List<Fixture>>>.toHomeFavouriteUiState(
    onMatchClick: () -> Unit,
    onLeagueClick: (leagueId: Int, season: Int) -> Unit
): List<FavoriteHomeItemUIState> {
    return this.map {
        FavoriteHomeItemUIState(
            title = it.first.name,
            imageUrl = it.first.imageUrl,
            leagueId = it.first.leagueId,
            season = it.first.season.toInt(),
            onclick = onLeagueClick,
            matches = it.second.map { fixture ->
                fixture.toMatchUIState(onMatchClick)
            }
        )
    }

}