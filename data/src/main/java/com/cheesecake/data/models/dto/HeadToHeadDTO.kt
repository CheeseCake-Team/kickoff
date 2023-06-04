package com.cheesecake.data.models.dto

import com.cheesecake.data.models.base.Fixture
import com.cheesecake.data.models.base.LeagueCountrySeasonRound
import com.cheesecake.data.models.base.Matches
import com.cheesecake.data.models.base.ScoreBlock
import com.cheesecake.data.models.base.TeamHomeAway
import com.google.gson.annotations.SerializedName

data class HeadToHeadDTO(
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
) {

}