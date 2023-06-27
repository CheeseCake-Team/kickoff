package com.cheesecake.presentation.screens.league.leagueDetails

import com.cheesecake.presentation.screens.league.LeagueNavigationEvent

sealed interface LeagueDetailsEvents {

    data class NavigateToTeamsStanding(val leagueId: Int ,val season: Int) : LeagueDetailsEvents
    data class NavigateToTopPlayer(val leagueId: Int ,val season: Int) : LeagueDetailsEvents

}