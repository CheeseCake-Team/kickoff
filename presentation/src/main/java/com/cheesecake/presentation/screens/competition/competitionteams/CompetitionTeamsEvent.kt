package com.cheesecake.presentation.screens.competition.competitionteams

sealed interface CompetitionTeamsEvent {
    data class TeamClickEvent(val teamId: Int) : CompetitionTeamsEvent
}