package com.cheesecake.data.models

import com.cheesecake.data.models.base.BasePeriods
import com.cheesecake.data.models.base.BaseStatus
import com.cheesecake.data.models.base.LeagueCountrySeasonRound
import com.cheesecake.data.models.base.Matches
import com.cheesecake.data.models.base.ScoreBlock
import com.cheesecake.data.models.base.TeamHomeAway
import com.cheesecake.data.models.base.VenueCity
import com.google.gson.annotations.SerializedName

data class HeadToHeadResponse(
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
    data class Fixture(
        @SerializedName("id")
        val id: Int,
        @SerializedName("referee")
        val referee: String,
        @SerializedName("timezone")
        val timezone: String,
        @SerializedName("date")
        val date: String,
        @SerializedName("timestamp")
        val timestamp: Int,
        @SerializedName("periods")
        val periods: BasePeriods,
        @SerializedName("venue")
        val venue: VenueCity,
        @SerializedName("status")
        val status: BaseStatus
    )
}