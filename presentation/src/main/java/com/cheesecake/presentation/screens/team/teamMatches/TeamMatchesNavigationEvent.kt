package com.cheesecake.presentation.screens.team.teamMatches

sealed interface TeamMatchesNavigationEvent {
    data class MatchClickedEvent(val homeTeamId: Int, val awayTeamId: Int, val date: String) :
        TeamMatchesNavigationEvent

    data class CompetitionClickedEvent(val competitionId: Int, val season: Int) :
        TeamMatchesNavigationEvent
}