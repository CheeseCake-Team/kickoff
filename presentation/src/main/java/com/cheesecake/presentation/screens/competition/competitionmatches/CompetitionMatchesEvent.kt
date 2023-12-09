package com.cheesecake.presentation.screens.competition.competitionmatches

sealed interface CompetitionMatchesEvent {
    data class MatchClickedEvent(val homeTeamId: Int, val awayTeamId: Int, val date: String) :
        CompetitionMatchesEvent
}