package com.cheesecake.presentation.screens.home

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.League
import com.cheesecake.presentation.mapper.toMatchUIState
import com.cheesecake.presentation.utils.toStanderDateString
import com.cheesecake.presentation.utils.toStanderTimeString
import java.text.SimpleDateFormat
import java.util.TimeZone

data class FavoriteHomeItemUIState(
    val title: String = "",
    val imageUrl: String = "",
    val leagueId: Int = 0,
    val isNoData: Boolean = false,
    val season: Int = 0,
    val onclick: (leagueId: Int, season: Int) -> Unit = { _, _ -> },
    val matches: List<MatchItemUIState> = emptyList(),
)

fun List<Pair<League, List<Fixture>>>.toHomeFavouriteUiState(
    onMatchClick: (homeTeamId: Int, awayTeamId: Int, date: String) -> Unit,
    onLeagueClick: (leagueId: Int, season: Int) -> Unit
): List<FavoriteHomeItemUIState> {
    return map {
        FavoriteHomeItemUIState(
            title = it.first.name,
            imageUrl = it.first.imageUrl,
            leagueId = it.first.leagueId,
            season = it.first.season.last(),
            onclick = onLeagueClick,
            isNoData = it.second.isEmpty(),
            matches = it.second.map { fixture ->
                fixture.toMatchUIState {
                    onMatchClick(
                        fixture.homeTeamID,
                        fixture.awayTeamID,
                        fixture.matchDate.toStanderDateString()
                    )
                }
            }
        )
    }

}
