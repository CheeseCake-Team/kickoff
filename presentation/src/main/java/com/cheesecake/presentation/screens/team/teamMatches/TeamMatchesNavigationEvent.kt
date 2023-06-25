package com.cheesecake.presentation.screens.team.teamMatches

import com.cheesecake.presentation.screens.home.HomeEvents

sealed interface TeamMatchesNavigationEvent{
    data class MatchClickedEvent(val homeTeamId: Int, val awayTeamId: Int, val date: String) :
        TeamMatchesNavigationEvent
}