package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.Team
import com.cheesecake.presentation.models.TeamUIState
import com.cheesecake.presentation.screens.home.MatchItemUIState
import java.text.SimpleDateFormat
import java.util.TimeZone


fun Team.toUIState(): TeamUIState {
    return TeamUIState(
        teamId = this.id,
        teamName = this.name,
        founded = this.yearFounded,
        teamCountry = this.country,
        venueCapacity = this.stadiumCapacity,
        venueName = this.stadiumName,
        imageUrl = this.imageUrl,
        isFavourite = this.isFavourite,
    )
}

//fun Fixture.toMatchUIState(): MatchItemUIState {
//    val timeFormat = SimpleDateFormat("HH:mm", Locale.ENGLISH)
//    val formattedMatchTime = matchDate.let { timeFormat.parse(it.toString())
//        ?.let { it1 -> timeFormat.format(it1) } } ?: ""
//
//    return MatchItemUIState(
//        leagueId = id,
//        leagueSeason = leagueSeason,
//        timeZone = TimeZone.getDefault().id,
//        matchState = if (isFinished) "Finished" else "Upcoming",
//        matchTime = formattedMatchTime,
//        homeTeamName = homeTeamName,
//        awayTeamName = awayTeamName,
//        homeTeamGoals = homeTeamGoals?.toIntOrNull() ?: 0,
//        awayTeamGoals = awayTeamGoals?.toIntOrNull() ?: 0,
//        homeTeamImageUrl = homeTeamLogoUrl,
//        awayTeamImageUrl = awayTeamLogoUrl
//    )
//}

fun Fixture.toMatchUIState(onclick: () -> Unit): MatchItemUIState {
    val formatter = SimpleDateFormat("HH:mm")
    val formattedMatchTime = formatter.format(this.matchDate)
//    val timeFormat = SimpleDateFormat("HH:mm", Locale.ENGLISH)
//    val formattedMatchTime = matchTime?.let { timeFormat.parse(it)
//        ?.let { it1 -> timeFormat.format(it1) } } ?: ""

    return MatchItemUIState(
        leagueId = id,
        leagueSeason = leagueSeason,
        timeZone = TimeZone.getDefault().id,
        matchState = if (isFinished) "Finished" else "Upcoming",
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


//data class MatchItemUIState(
//    val leagueId: Int = 0,
//    val leagueSeason: Int = 0,
//    val timeZone: String = "",
//    val matchState: String = "",
//    val matchTime: String = "",
//    val homeTeamName: String = "",
//    val awayTeamName: String = "",
//    val homeTeamGoals: Int = 0,
//    val awayTeamGoals: Int = 0,
//    val homeTeamImageUrl: String = "",
//    val awayTeamImageUrl: String = ""
//)
//
//data class Fixture(
//    val id: Int,
//    val leagueName: String,
//    val homeTeamName: String,
//    val homeTeamLogoUrl: String,
//    val homeTeamGoals: String?,
//    val awayTeamName: String,
//    val awayTeamLogoUrl: String,
//    val awayTeamGoals: String?,
//    val matchTime: String?,
//    val matchDate: Date,
//    val isFinished: Boolean = false
//)

