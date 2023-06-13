package com.cheesecake.data.remote.models

import com.cheesecake.data.remote.models.*
import com.google.gson.annotations.SerializedName

data class PredictionsDTO(
    @SerializedName("comparison")
    val comparison: Comparison,
    @SerializedName("h2h")
    val h2h: List<H2h>,
    @SerializedName("league")
    val league: LeagueCountrySeasonDTO,
    @SerializedName("predictions")
    val predictions: Predictions,
    @SerializedName("teams")
    val teams: Teams
) {
    data class Comparison(
        @SerializedName("att")
        val att: MatchesDTO,
        @SerializedName("def")
        val def: MatchesDTO,
        @SerializedName("form")
        val form: MatchesDTO,
        @SerializedName("goals")
        val goals: MatchesDTO,
        @SerializedName("h2h")
        val h2h: MatchesDTO,
        @SerializedName("poisson_distribution")
        val poissonDistribution: MatchesDTO,
        @SerializedName("total")
        val total: MatchesDTO
    )

    data class H2h(
        @SerializedName("fixture")
        val fixture: Fixture,
        @SerializedName("goals")
        val goals: MatchesDTO,
        @SerializedName("league")
        val league: LeagueCountrySeasonRoundDTO,
        @SerializedName("score")
        val score: ScoreBlockDTO,
        @SerializedName("teams")
        val teams: TeamHomeAwayDTO
    ) {
        data class Fixture(
            @SerializedName("date")
            val date: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("periods")
            val periods: BasePeriodsDTO,
            @SerializedName("referee")
            val referee: String,
            @SerializedName("status")
            val status: BaseStatusDTO,
            @SerializedName("timestamp")
            val timestamp: Int,
            @SerializedName("timezone")
            val timezone: String,
            @SerializedName("venue")
            val venue: VenueCityDTO
        )
    }

    data class Predictions(
        @SerializedName("advice")
        val advice: String,
        @SerializedName("goals")
        val goals: ScoreStatusStringDTO,
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
        val away: TeamLargeDTO,
        @SerializedName("home")
        val home: TeamLargeDTO
    )
}