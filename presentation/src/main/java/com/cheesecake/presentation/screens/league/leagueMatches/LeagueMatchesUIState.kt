package com.cheesecake.presentation.screens.league.leagueMatches

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.presentation.screens.home.MatchItemUIState
import com.cheesecake.presentation.utils.toStanderDateString
import com.cheesecake.presentation.utils.toStanderTimeString

data class LeagueMatchesUIState(
    val data: List<DateMatchesItemUIState> = emptyList(),
    val errorMessage: String = "",
    val isLoading: Boolean = true
)

data class DateMatchesItemUIState(
    val date: String = "",
    val matches: List<MatchItemUIState> = emptyList()
)

fun List<Pair<String, List<Fixture>>>.toUIState(onclick: (Int,Int, String) -> Unit): List<DateMatchesItemUIState> {
    return map { (date, fixtures) ->
        val matches = fixtures.toUIState(onclick)
        DateMatchesItemUIState(date = date, matches = matches)
    }
}

@JvmName("toMatchItemUIStateList")
fun List<Fixture>.toUIState(onclick: (Int,Int, String) -> Unit): List<MatchItemUIState> {
    return map { fixture ->
        MatchItemUIState(
            fixture.matchState,
            homeTeamName = fixture.homeTeamName,
            homeTeamImageUrl = fixture.homeTeamLogoUrl,
            homeTeamGoals = fixture.homeTeamGoals ?: "0",
            awayTeamName = fixture.awayTeamName,
            awayTeamImageUrl = fixture.awayTeamLogoUrl,
            awayTeamGoals = fixture.awayTeamGoals ?: "0",
            matchTime = fixture.matchDate.toStanderTimeString(),
            matchDate = fixture.matchDate.toStanderDateString(),
            onclick = { onclick(fixture.homeTeamID, fixture.awayTeamID, fixture.matchDate.toStanderDateString()) }
        )

    }
}