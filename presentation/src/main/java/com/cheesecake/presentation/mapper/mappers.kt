package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.entity.Country
import com.cheesecake.domain.entity.PlayerStatistics
import com.cheesecake.domain.entity.SquadPlayer
import com.cheesecake.presentation.models.CountryItemUIState
import com.cheesecake.presentation.models.TeamUIState
import com.cheesecake.presentation.screens.player.playerStatistics.PlayerDataItemUIState
import com.cheesecake.presentation.screens.player.playerStatistics.PlayerSectionItemUIState
import com.cheesecake.presentation.screens.team.teamPlayers.SquadPlayerItemUIState


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
                PlayerDataItemUIState("Birth Date", this.date),
                PlayerDataItemUIState("Birth Place", this.place),
                PlayerDataItemUIState("Birth Country", this.country),
                PlayerDataItemUIState("Nationality", this.nationality),
                PlayerDataItemUIState("Height", this.height),
                PlayerDataItemUIState("Weight", this.weight),
                PlayerDataItemUIState("Injured", this.injured.toString()),
                PlayerDataItemUIState("Rating", this.rating),
                PlayerDataItemUIState("Captain", this.country)
            )
        ),
        PlayerSectionItemUIState(
            "Games Info", listOf(
                PlayerDataItemUIState("Appearances", appearences.toString()),
                PlayerDataItemUIState("Lineups", lineups.toString()),
                PlayerDataItemUIState("Minutes", minutes.toString()),
                PlayerDataItemUIState("Number", number.toString()),
                PlayerDataItemUIState("Position", position),
            )
        ),
        PlayerSectionItemUIState(
            "Goals Info", listOf(
                PlayerDataItemUIState("goals", goals),
            )
        )
    )
}

fun SquadPlayer.mapIt(onClick: () -> Unit): SquadPlayerItemUIState {
    return SquadPlayerItemUIState(
        name, ImageUrl ,number, onClick
    )
}