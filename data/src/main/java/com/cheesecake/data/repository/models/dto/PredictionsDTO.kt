package com.cheesecake.data.repository.models.dto

import com.cheesecake.data.repository.models.base.BasePeriods
import com.cheesecake.data.repository.models.base.BaseStatus
import com.cheesecake.data.repository.models.base.LeagueCountrySeason
import com.cheesecake.data.repository.models.base.LeagueCountrySeasonRound
import com.cheesecake.data.repository.models.base.Matches
import com.cheesecake.data.repository.models.base.ScoreBlock
import com.cheesecake.data.repository.models.base.ScoreStatusString
import com.cheesecake.data.repository.models.base.TeamHomeAway
import com.cheesecake.data.repository.models.base.TeamLarge
import com.cheesecake.data.repository.models.base.VenueCity
import com.google.gson.annotations.SerializedName

data class PredictionsDTO(
    @SerializedName("comparison")
    val comparison: Comparison,
    @SerializedName("h2h")
    val h2h: List<H2h>,
    @SerializedName("league")
    val league: com.cheesecake.data.repository.models.base.LeagueCountrySeason,
    @SerializedName("predictions")
    val predictions: Predictions,
    @SerializedName("teams")
    val teams: Teams
) {
    data class Comparison(
        @SerializedName("att")
        val att: com.cheesecake.data.repository.models.base.Matches,
        @SerializedName("def")
        val def: com.cheesecake.data.repository.models.base.Matches,
        @SerializedName("form")
        val form: com.cheesecake.data.repository.models.base.Matches,
        @SerializedName("goals")
        val goals: com.cheesecake.data.repository.models.base.Matches,
        @SerializedName("h2h")
        val h2h: com.cheesecake.data.repository.models.base.Matches,
        @SerializedName("poisson_distribution")
        val poissonDistribution: com.cheesecake.data.repository.models.base.Matches,
        @SerializedName("total")
        val total: com.cheesecake.data.repository.models.base.Matches
    )

    data class H2h(
        @SerializedName("fixture")
        val fixture: Fixture,
        @SerializedName("goals")
        val goals: com.cheesecake.data.repository.models.base.Matches,
        @SerializedName("league")
        val league: com.cheesecake.data.repository.models.base.LeagueCountrySeasonRound,
        @SerializedName("score")
        val score: com.cheesecake.data.repository.models.base.ScoreBlock,
        @SerializedName("teams")
        val teams: com.cheesecake.data.repository.models.base.TeamHomeAway
    ) {
        data class Fixture(
            @SerializedName("date")
            val date: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("periods")
            val periods: com.cheesecake.data.repository.models.base.BasePeriods,
            @SerializedName("referee")
            val referee: String,
            @SerializedName("status")
            val status: com.cheesecake.data.repository.models.base.BaseStatus,
            @SerializedName("timestamp")
            val timestamp: Int,
            @SerializedName("timezone")
            val timezone: String,
            @SerializedName("venue")
            val venue: com.cheesecake.data.repository.models.base.VenueCity
        )
    }

    data class Predictions(
        @SerializedName("advice")
        val advice: String,
        @SerializedName("goals")
        val goals: com.cheesecake.data.repository.models.base.ScoreStatusString,
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
        val away: com.cheesecake.data.repository.models.base.TeamLarge,
        @SerializedName("home")
        val home: com.cheesecake.data.repository.models.base.TeamLarge
    )
}