package com.cheesecake.data.models


import com.cheesecake.data.models.base.HomeAway
import com.cheesecake.data.models.base.Matches
import com.google.gson.annotations.SerializedName

data class HeadToHeadResponse(
    @SerializedName("fixture")
    val fixture: Fixture,
    @SerializedName("league")
    val league: League,
    @SerializedName("teams")
    val teams: Teams,
    @SerializedName("goals")
    val goals: Goals,
    @SerializedName("score")
    val score: Score
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
        val periods: Periods,
        @SerializedName("venue")
        val venue: Venue,
        @SerializedName("status")
        val status: Status
    ) {
        data class Periods(
            @SerializedName("first")
            val first: Int,
            @SerializedName("second")
            val second: Int
        )

        data class Venue(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("city")
            val city: String
        )

        data class Status(
            @SerializedName("long")
            val long: String,
            @SerializedName("short")
            val short: String,
            @SerializedName("elapsed")
            val elapsed: Int
        )
    }

    data class League(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("country")
        val country: String,
        @SerializedName("logo")
        val logo: String,
        @SerializedName("flag")
        val flag: String,
        @SerializedName("season")
        val season: Int,
        @SerializedName("round")
        val round: String
    )

    data class Teams(
        @SerializedName("home")
        val home: HomeAway,
        @SerializedName("away")
        val away: HomeAway
    )
    data class Goals(
        @SerializedName("home")
        val home: Int,
        @SerializedName("away")
        val away: Int
    )
    data class Score(
        @SerializedName("halftime")
        val halftime: Matches,
        @SerializedName("fulltime")
        val fulltime: Matches,
        @SerializedName("extratime")
        val extratime: Matches,
        @SerializedName("penalty")
        val penalty: Matches
    )
}