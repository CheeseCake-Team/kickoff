package com.cheesecake.data.models

import com.cheesecake.data.models.base.BasePeriods
import com.cheesecake.data.models.base.BaseStatus
import com.cheesecake.data.models.base.LeagueCountrySeason
import com.cheesecake.data.models.base.LeagueCountrySeasonRound
import com.cheesecake.data.models.base.Matches
import com.cheesecake.data.models.base.ScoreBlock
import com.cheesecake.data.models.base.ScoreStatusString
import com.cheesecake.data.models.base.TeamHomeAway
import com.cheesecake.data.models.base.TeamLarge
import com.cheesecake.data.models.base.VenueCity
import com.google.gson.annotations.SerializedName

data class PredictionsDTO(
    @SerializedName("comparison")
    val comparison: Comparison,
    @SerializedName("h2h")
    val h2h: List<H2h>,
    @SerializedName("league")
    val league: LeagueCountrySeason,
    @SerializedName("predictions")
    val predictions: Predictions,
    @SerializedName("teams")
    val teams: Teams
) {
    data class Comparison(
        @SerializedName("att")
        val att: Matches,
        @SerializedName("def")
        val def: Matches,
        @SerializedName("form")
        val form: Matches,
        @SerializedName("goals")
        val goals: Matches,
        @SerializedName("h2h")
        val h2h: Matches,
        @SerializedName("poisson_distribution")
        val poissonDistribution: Matches,
        @SerializedName("total")
        val total: Matches
    )

    data class H2h(
        @SerializedName("fixture")
        val fixture: Fixture,
        @SerializedName("goals")
        val goals: Matches,
        @SerializedName("league")
        val league: LeagueCountrySeasonRound,
        @SerializedName("score")
        val score: ScoreBlock,
        @SerializedName("teams")
        val teams: TeamHomeAway
    ) {
        data class Fixture(
            @SerializedName("date")
            val date: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("periods")
            val periods: BasePeriods,
            @SerializedName("referee")
            val referee: String,
            @SerializedName("status")
            val status: BaseStatus,
            @SerializedName("timestamp")
            val timestamp: Int,
            @SerializedName("timezone")
            val timezone: String,
            @SerializedName("venue")
            val venue: VenueCity
        )
    }

    data class Predictions(
        @SerializedName("advice")
        val advice: String,
        @SerializedName("goals")
        val goals: ScoreStatusString,
        @SerializedName("percent")
        val percent: Percent,
        @SerializedName("under_over")
        val underOver: String,
        @SerializedName("win_or_draw")
        val winOrDraw: Boolean,
        @SerializedName("winner")
        val winner: Winner
    ) {
        data class Percent(
            @SerializedName("away")
            val away: String,
            @SerializedName("draw")
            val draw: String,
            @SerializedName("home")
            val home: String
        )

        data class Winner(
            @SerializedName("comment")
            val comment: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String
        )
    }

    data class Teams(
        @SerializedName("away")
        val away: TeamLarge,
        @SerializedName("home")
        val home: TeamLarge
    )
}