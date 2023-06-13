package com.cheesecake.data.remote.models

import com.cheesecake.data.remote.models.*
import com.google.gson.annotations.SerializedName

data class HeadToHeadDTO(
    @SerializedName("fixture")
    val fixtureDataDTO: FixtureDataDTO,
    @SerializedName("league")
    val league: LeagueCountrySeasonRoundDTO,
    @SerializedName("teams")
    val teams: TeamHomeAwayDTO,
    @SerializedName("goals")
    val goals: MatchesDTO,
    @SerializedName("score")
    val score: ScoreBlockDTO
) {

}