package com.cheesecake.presentation.mapper

import android.util.Log
import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.entity.Country
import com.cheesecake.domain.entity.Fixture
import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.entity.SquadPlayer
import com.cheesecake.presentation.models.CountryItemUIState
import com.cheesecake.presentation.models.TeamUIState
import com.cheesecake.presentation.screens.home.MatchItemUiState
import com.cheesecake.presentation.screens.player.playerStatistics.PlayerDataItemUIState
import com.cheesecake.presentation.screens.player.playerStatistics.PlayerSectionItemUIState
import com.cheesecake.presentation.screens.team.teamMatches.TeamMatchItemUIState
import com.cheesecake.presentation.screens.team.teamPlayers.SquadPlayerItemUIState
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

fun PlayerStatistics.toPlayerStatisticsUIModel(): List<PlayerSectionItemUIState> {
    return listOf(
        PlayerSectionItemUIState(
            "Personal Info", listOf(
                PlayerDataItemUIState("Name", this.name),
                PlayerDataItemUIState("Age", this.age.toString()),
                PlayerDataItemUIState("Birth Date", this.birthDate),
                PlayerDataItemUIState("Birth Place", this.birthPlace ?: "Not assigned"),
                PlayerDataItemUIState("Birth Country", this.birthCountry),
                PlayerDataItemUIState("Nationality", this.nationality),
                PlayerDataItemUIState("Height", this.heightInCm),
                PlayerDataItemUIState("Weight", this.weightInKg),
                PlayerDataItemUIState("Injured", this.isInjured.toString()),
                PlayerDataItemUIState("Rating", this.rating),
                PlayerDataItemUIState("Captain", this.birthCountry)
            )
        ),
        PlayerSectionItemUIState(
            "Games Info", listOf(
                PlayerDataItemUIState("Appearances", appearances.toString()),
                PlayerDataItemUIState("Lineups", lineups.toString()),
                PlayerDataItemUIState("Minutes", minutes.toString()),
                PlayerDataItemUIState("Number", number.toString()),
                PlayerDataItemUIState("Position", position),
            )
        ),
        PlayerSectionItemUIState(
            "Goals Info", listOf(
                PlayerDataItemUIState("goals", goals.toString()),
            )
        )
    )
}

fun SquadPlayer.mapIt(onClick: () -> Unit): SquadPlayerItemUIState {
    return SquadPlayerItemUIState(
        name, ImageUrl, number, onClick
    )
}

fun Fixture.toTeamMatchItemUIState(onClick: (Int, Int, String) -> Unit): TeamMatchItemUIState =
    TeamMatchItemUIState(
        MatchItemUiState(
            matchState,
            matchDate.toStanderDateString(),
            matchDate.toStanderTimeString(),
            homeTeamName,
            awayTeamName,
            homeTeamGoals ?: "0",
            awayTeamGoals ?: "0",
            homeTeamLogoUrl,
            awayTeamLogoUrl,

            onclick = {
                Log.d("TAaaaaag", "$homeTeamID $awayTeamID $matchDate")

                onClick(
                    homeTeamID,
                    awayTeamID,
                    matchDate.toStanderDateString()
                )
            }
        ),
        leagueName,
        leagueLogoUrl
    )

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
        onclick = onclick
    )
}