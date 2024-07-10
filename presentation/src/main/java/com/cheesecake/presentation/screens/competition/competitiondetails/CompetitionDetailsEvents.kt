package com.cheesecake.presentation.screens.competition.competitiondetails

sealed interface CompetitionDetailsEvents {
    data class NavigateToTeamsStanding(val leagueId: Int ,val season: Int) : CompetitionDetailsEvents
    data class NavigateToTopPlayer(val leagueId: Int ,val season: Int) : CompetitionDetailsEvents
}