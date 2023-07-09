package com.cheesecake.presentation.screens.league.leagueTeams

sealed interface LeagueTeamsEvent {
    data class TeamClickEvent(val teamId: Int) : LeagueTeamsEvent
}