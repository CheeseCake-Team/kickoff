package com.cheesecake.data.remote.response

import com.cheesecake.data.remote.models.BasePeriodsDTO
import com.cheesecake.data.remote.models.BaseStatusDTO
import com.cheesecake.data.remote.models.LeagueCountrySeasonDTO
import com.cheesecake.data.remote.models.LeagueCountrySeasonRoundDTO
import com.cheesecake.data.remote.models.MatchesDTO
import com.cheesecake.data.remote.models.ScoreBlockDTO
import com.cheesecake.data.remote.models.ScoreStatusStringDTO
import com.cheesecake.data.remote.models.TeamHomeAwayDTO
import com.cheesecake.data.remote.models.TeamLargeDTO
import com.cheesecake.data.remote.models.VenueCityDTO
import com.google.gson.annotations.SerializedName

data class PredictionsResponse(
    @SerializedName("comparison")
    val comparison: Comparison,
    @SerializedName("h2h")
    val h2h: List<H2h>,
    @SerializedName("league")
    val league: com.cheesecake.data.remote.models.LeagueCountrySeasonDTO,
    @SerializedName("predictions")
    val predictions: Predictions,
    @SerializedName("teams")
    val teams: Teams
) {
    data class Comparison(
        @SerializedName("att")
        val att: com.cheesecake.data.remote.models.MatchesDTO,
        @SerializedName("def")
        val def: com.cheesecake.data.remote.models.MatchesDTO,
        @SerializedName("form")
        val form: com.cheesecake.data.remote.models.MatchesDTO,
        @SerializedName("goals")
        val goals: com.cheesecake.data.remote.models.MatchesDTO,
        @SerializedName("h2h")
        val h2h: com.cheesecake.data.remote.models.MatchesDTO,
        @SerializedName("poisson_distribution")
        val poissonDistribution: com.cheesecake.data.remote.models.MatchesDTO,
        @SerializedName("total")
        val total: com.cheesecake.data.remote.models.MatchesDTO
    )

    data class H2h(
        @SerializedName("fixture")
        val fixture: Fixture,
        @SerializedName("goals")
        val goals: com.cheesecake.data.remote.models.MatchesDTO,
        @SerializedName("league")
        val league: com.cheesecake.data.remote.models.LeagueCountrySeasonRoundDTO,
        @SerializedName("score")
        val score: com.cheesecake.data.remote.models.ScoreBlockDTO,
        @SerializedName("teams")
        val teams: com.cheesecake.data.remote.models.TeamHomeAwayDTO
    ) {
        data class Fixture(
            @SerializedName("date")
            val date: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("periods")
            val periods: com.cheesecake.data.remote.models.BasePeriodsDTO,
            @SerializedName("referee")
            val referee: String,
            @SerializedName("status")
            val status: com.cheesecake.data.remote.models.BaseStatusDTO,
            @SerializedName("timestamp")
            val timestamp: Int,
            @SerializedName("timezone")
            val timezone: String,
            @SerializedName("venue")
            val venue: com.cheesecake.data.remote.models.VenueCityDTO
        )
    }

    data class Predictions(
        @SerializedName("advice")
        val advice: String,
        @SerializedName("goals")
        val goals: com.cheesecake.data.remote.models.ScoreStatusStringDTO,
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
        val away: com.cheesecake.data.remote.models.TeamLargeDTO,
        @SerializedName("home")
        val home: com.cheesecake.data.remote.models.TeamLargeDTO
    )
}