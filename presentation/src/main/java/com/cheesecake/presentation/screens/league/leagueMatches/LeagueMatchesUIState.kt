package com.cheesecake.presentation.screens.league.leagueMatches

import android.util.Log
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.presentation.utils.toStanderDateString
import java.util.Date

data class LeagueMatchesUIState(
    val data: List<DateMatchesItem> = emptyList(),
    val errorMessage: String = "",
    val isLoading: Boolean = true
)

data class MatchItemUIState(
    val homeTeamName: String = "",
    val homeTeamLogoUrl: String = "",
    val homeTeamGoals: Int = 0,
    val awayTeamName: String = "",
    val awayTeamLogoUrl: String = "",
    val awayTeamGoals: Int = 0,
    val isFinished: Boolean = false,
    val matchTime: String = "",
    val onclick: () -> Unit = {}
)

data class DateMatchesItem(
    val date: String = "",
    val matches: List<MatchItemUIState> = emptyList()
)

fun List<Pair<String, List<Fixture>>>.toUIState(onclick: (Int,Int, String) -> Unit): List<DateMatchesItem> {
    return map { (date, fixtures) ->
        val matches = fixtures.toUIState(onclick)
        DateMatchesItem(date = date, matches = matches)
    }
}

@JvmName("toMatchItemUIStateList")
fun List<Fixture>.toUIState(onclick: (Int,Int, String) -> Unit): List<MatchItemUIState> {
    return map { fixture ->
        MatchItemUIState(
            homeTeamName = fixture.homeTeamName,
            homeTeamLogoUrl = fixture.homeTeamLogoUrl,
            homeTeamGoals = fixture.homeTeamGoals?.toIntOrNull() ?: 0,
            awayTeamName = fixture.awayTeamName,
            awayTeamLogoUrl = fixture.awayTeamLogoUrl,
            awayTeamGoals = fixture.awayTeamGoals?.toIntOrNull() ?: 0,
            isFinished = fixture.isFinished,
            matchTime = fixture.matchTime ?: "",
            onclick = { onclick(fixture.homeTeamID, fixture.awayTeamID, fixture.matchDate.toStanderDateString()) }
        )

    }
}