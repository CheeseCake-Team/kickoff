package com.cheesecake.presentation.screens.competition.competitionmatches

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.presentation.screens.home.MatchItemUiState
import com.cheesecake.presentation.utils.toStanderDateString
import com.cheesecake.presentation.utils.toStanderTimeString

fun List<Pair<String, List<Fixture>>>.toUiState(onclick: (Int, Int, String) -> Unit): List<DateMatchesItemUiState> {
    return map { (date, fixtures) ->
        val matches = fixtures.toUiState(onclick)
        DateMatchesItemUiState(date = date, matches = matches)
    }
}

@JvmName("toMatchItemUIStateList")
fun List<Fixture>.toUiState(onclick: (Int, Int, String) -> Unit): List<MatchItemUiState> {
    return map { fixture ->
        MatchItemUiState(
            fixture.matchState,
            homeTeamName = fixture.homeTeamName,
            homeTeamImageUrl = fixture.homeTeamLogoUrl,
            homeTeamGoals = fixture.homeTeamGoals ?: "0",
            awayTeamName = fixture.awayTeamName,
            awayTeamImageUrl = fixture.awayTeamLogoUrl,
            awayTeamGoals = fixture.awayTeamGoals ?: "0",
            matchTime = fixture.matchDate.toStanderTimeString(),
            matchDate = fixture.matchDate.toStanderDateString(),
            onMatchClicked = {
                onclick(
                    fixture.homeTeamID,
                    fixture.awayTeamID,
                    fixture.matchDate.toStanderDateString()
                )
            }
        )
    }
}