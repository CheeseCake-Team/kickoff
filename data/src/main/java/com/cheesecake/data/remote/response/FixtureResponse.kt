package com.cheesecake.data.remote.response


import com.cheesecake.data.models.base.Fixture
import com.cheesecake.data.models.base.LeagueCountrySeasonRound
import com.cheesecake.data.models.base.Matches
import com.cheesecake.data.models.base.ScoreBlock
import com.cheesecake.data.models.base.TeamHomeAway
import com.cheesecake.domain.models.FixtureEntity
import com.google.gson.annotations.SerializedName

data class FixtureResponse(
    @SerializedName("fixture")
    val fixture: Fixture,
    @SerializedName("league")
    val league: LeagueCountrySeasonRound,
    @SerializedName("teams")
    val teams: TeamHomeAway,
    @SerializedName("goals")
    val goals: Matches,
    @SerializedName("score")
    val score: ScoreBlock
)

fun FixtureResponse.mapToDomain(): FixtureEntity {
    return FixtureEntity(
        homeTeamName = this.teams.home.name,
        homeTeamLogo = this.league.logo,
        homeTeamGoals = this.goals.home,
        awayTeamName = this.teams.away.name,
        awayTeamLogo = this.teams.away.logo,
        awayTeamGoals = this.goals.away,
        matchTime = fixture.timestamp,
        isFinished = false
    )
}

fun List<FixtureResponse>.mapToDomain(): List<FixtureEntity> {
    return this.map { it.mapToDomain() }
}