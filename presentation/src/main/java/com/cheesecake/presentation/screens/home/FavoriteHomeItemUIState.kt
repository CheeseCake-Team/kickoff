package com.cheesecake.presentation.screens.home

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.League
import com.cheesecake.presentation.utils.toStanderDateString
import com.cheesecake.presentation.utils.toStanderTimeString
import java.text.SimpleDateFormat
import java.util.TimeZone

data class FavoriteHomeItemUIState(
    val title: String = "",
    val imageUrl: String = "",
    val leagueId: Int = 0,
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
            season = it.first.season.toInt(),
            onclick = onLeagueClick,
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

fun Fixture.toMatchUIState(onclick: () -> Unit): MatchItemUIState {
    return MatchItemUIState(
        timeZone = TimeZone.getDefault().id,
        matchState = if (isFinished) "Finished" else "Upcoming",
        matchDate = matchDate.toStanderDateString(),
        matchTime = this.matchDate.toStanderTimeString(),
        homeTeamName = homeTeamName,
        awayTeamName = awayTeamName,
        homeTeamGoals = homeTeamGoals?.toIntOrNull() ?: 0,
        awayTeamGoals = awayTeamGoals?.toIntOrNull() ?: 0,
        homeTeamImageUrl = homeTeamLogoUrl,
        awayTeamImageUrl = awayTeamLogoUrl,
        onclick =  onclick
    )
}
