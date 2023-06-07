package com.cheesecake.data.repository.models.response


import com.cheesecake.data.repository.models.dto.FixtureDTO
import com.cheesecake.data.repository.models.dto.LeagueCountrySeasonRoundDTO
import com.cheesecake.data.repository.models.dto.MatchesDTO
import com.cheesecake.data.repository.models.dto.ScoreBlockDTO
import com.cheesecake.data.repository.models.dto.TeamHomeAwayDTO
import com.cheesecake.domain.entity.FixtureEntity
import com.google.gson.annotations.SerializedName

data class FixtureResponse(
    @SerializedName("fixture")
    val fixtureDTO: FixtureDTO,
    @SerializedName("league")
    val league: LeagueCountrySeasonRoundDTO,
    @SerializedName("teams")
    val teams: TeamHomeAwayDTO,
    @SerializedName("goals")
    val goals: MatchesDTO,
    @SerializedName("score")
    val score: ScoreBlockDTO
)


fun FixtureResponse.mapToDomain(): FixtureEntity {
    return FixtureEntity(
        homeTeamName = this.teams.home.name,
        homeTeamLogo = this.league.logo,
        homeTeamGoals = this.goals.home,
        awayTeamName = this.teams.away.name,
        awayTeamLogo = this.teams.away.logo,
        awayTeamGoals = this.goals.away,
        matchTime = this.fixtureDTO.timestamp,
        isFinished = false
    )
}

fun List<FixtureResponse>.mapToDomain(): List<FixtureEntity> {
    return this.map { it.mapToDomain() }
}