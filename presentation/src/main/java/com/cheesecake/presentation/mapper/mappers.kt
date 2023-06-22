package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.entity.Country
import com.cheesecake.presentation.models.CountryItemUIState
import com.cheesecake.presentation.models.TeamUIState
import com.cheesecake.presentation.screens.home.MatchItemUIState
import com.cheesecake.presentation.utils.toFormattedString
import java.text.SimpleDateFormat
import java.util.TimeZone


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

fun Fixture.toMatchUIState(onclick: (matchId: String, season: Int, date: String) -> Unit): MatchItemUIState {
    val formatter = SimpleDateFormat("HH:mm")
    val formattedMatchTime = formatter.format(this.matchDate)

    return MatchItemUIState(
        leagueId = id,
        matchId = matchId,
        leagueSeason = leagueSeason,
        timeZone = TimeZone.getDefault().id,
        matchState = if (isFinished) "Finished" else "Upcoming",
        matchDate = matchDate.toFormattedString(),
        matchTime = formattedMatchTime,
        homeTeamName = homeTeamName,
        awayTeamName = awayTeamName,
        homeTeamGoals = homeTeamGoals?.toIntOrNull() ?: 0,
        awayTeamGoals = awayTeamGoals?.toIntOrNull() ?: 0,
        homeTeamImageUrl = homeTeamLogoUrl,
        awayTeamImageUrl = awayTeamLogoUrl,
        onclick = onclick
    )
}
