package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.Country
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.SquadPlayer
import com.cheesecake.domain.entity.Team
import com.cheesecake.presentation.models.CountryItemUIState
import com.cheesecake.presentation.models.TeamUIState
import com.cheesecake.presentation.screens.home.MatchItemUiState
import com.cheesecake.presentation.screens.team.teamPlayers.SquadPlayerItemUiState
import com.cheesecake.presentation.utils.toStanderDateString
import com.cheesecake.presentation.utils.toStanderTimeString


fun Team.toTeamUIState(onClick: () -> Unit): TeamUIState {
    return TeamUIState(
        teamName = this.name,
        founded = this.yearFounded,
        teamCountry = this.country,
        venueCapacity = this.stadiumCapacity,
        venueName = this.stadiumName,
        imageUrl = this.imageUrl,
        onTeamClick = onClick
    )
}


fun Country.toUIModel(onClick: () -> Unit): CountryItemUIState {
    return CountryItemUIState(
        name = name,
        flag = flag,
        onClick = onClick
    )
}

fun SquadPlayer.mapIt(onClick: () -> Unit): SquadPlayerItemUiState {
    return SquadPlayerItemUiState(
        name, ImageUrl, if(number == -1) "NA" else number.toString(), onClick
    )
}

fun Fixture.toMatchUIState(onclick: () -> Unit): MatchItemUiState {
    return MatchItemUiState(
        matchState,
        matchDate.toStanderDateString(),
        matchDate.toStanderTimeString(),
        homeTeamName,
        awayTeamName,
        homeTeamGoals ?: "0",
        awayTeamGoals ?: "0",
        homeTeamLogoUrl,
        awayTeamLogoUrl,
        onMatchClicked = onclick
    )
}