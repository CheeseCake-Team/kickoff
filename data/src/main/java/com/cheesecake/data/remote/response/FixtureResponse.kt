package com.cheesecake.data.remote.response


import com.cheesecake.domain.entity.FixtureEntity
import com.google.gson.annotations.SerializedName

data class FixtureResponse(
    @SerializedName("fixture")
    val fixtureDTO: com.cheesecake.data.remote.models.FixtureDTO,
    @SerializedName("league")
    val league: com.cheesecake.data.remote.models.LeagueCountrySeasonRoundDTO,
    @SerializedName("teams")
    val teams: com.cheesecake.data.remote.models.TeamHomeAwayDTO,
    @SerializedName("goals")
    val goals: com.cheesecake.data.remote.models.MatchesDTO,
    @SerializedName("score")
    val score: com.cheesecake.data.remote.models.ScoreBlockDTO
)


fun FixtureResponse.mapToDomain(): FixtureEntity {
    return FixtureEntity(
        homeTeamName = this.teams.home.name,
        homeTeamLogo = this.league.logo,
        homeTeamGoals = this.goals.home.toString(),
        awayTeamName = this.teams.away.name,
        awayTeamLogo = this.teams.away.logo,
        awayTeamGoals = this.goals.away.toString(),
        matchTime = this.fixtureDTO.timestamp,
        matchDate = this.fixtureDTO.date,
        isFinished = false
    )
}

fun List<FixtureResponse>.mapToDomain(): List<FixtureEntity> {
    return this.map { it.mapToDomain() }
}