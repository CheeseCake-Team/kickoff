package com.cheesecake.presentation.screens.home

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.League
import com.cheesecake.presentation.mapper.toMatchUIState

data class FavoriteHomeItemUIState(
    val title: String = "",
    val imageUrl: String = "",
    val onclick: () -> Unit = {},
    val matches: List<MatchItemUIState> = emptyList(),
)

fun List<Pair<League, List<Fixture>>>.toHomeFavouriteUiState(
    onMatchClick: () -> Unit,
    onLeagueClick: () -> Unit
): List<FavoriteHomeItemUIState> {
    return this.map {
        FavoriteHomeItemUIState(
            title = it.first.name,
            imageUrl = it.first.imageUrl,
            onclick = onLeagueClick,
            matches = it.second.map { fixture ->
                fixture.toMatchUIState(onMatchClick)
            }
        )
    }

}