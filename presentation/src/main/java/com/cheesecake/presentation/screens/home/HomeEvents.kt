package com.cheesecake.presentation.screens.home

sealed interface HomeEvents {
    data class NavigateToMatch(val homeTeamId: Int, val awayTeamId: Int, val date: String) :
        HomeEvents

    data class NavigateToCompetition(val competitionId: Int, val season: Int) : HomeEvents
}