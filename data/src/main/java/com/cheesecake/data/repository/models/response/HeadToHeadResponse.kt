package com.cheesecake.data.repository.models.response

import com.cheesecake.data.repository.models.dto.FixtureDTO
import com.cheesecake.data.repository.models.dto.LeagueCountrySeasonRoundDTO
import com.cheesecake.data.repository.models.dto.MatchesDTO
import com.cheesecake.data.repository.models.dto.ScoreBlockDTO
import com.cheesecake.data.repository.models.dto.TeamHomeAwayDTO
import com.google.gson.annotations.SerializedName

data class HeadToHeadResponse(
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
) {

}