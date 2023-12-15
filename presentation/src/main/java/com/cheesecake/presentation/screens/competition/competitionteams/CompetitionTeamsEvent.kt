package com.cheesecake.presentation.screens.competition.competitionteams

sealed interface CompetitionTeamsEvent {
    data class TeamClickEvent(val teamId: Int, val competitionId: Int, val season: Int) :
        CompetitionTeamsEvent
}