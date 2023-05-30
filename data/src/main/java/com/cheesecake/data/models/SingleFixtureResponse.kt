package com.cheesecake.data.models


import com.google.gson.annotations.SerializedName

data class SingleFixtureResponse(
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
        val home: Home,
        @SerializedName("away")
        val away: Away
    ) {
        data class Home(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("logo")
            val logo: String,
            @SerializedName("winner")
            val winner: Boolean
        )

        data class Away(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("logo")
            val logo: String,
            @SerializedName("winner")
            val winner: Boolean
        )
    }

    data class Goals(
        @SerializedName("home")
        val home: Int,
        @SerializedName("away")
        val away: Int
    )

    data class Score(
        @SerializedName("halftime")
        val halftime: Halftime,
        @SerializedName("fulltime")
        val fulltime: Fulltime,
        @SerializedName("extratime")
        val extratime: Extratime,
        @SerializedName("penalty")
        val penalty: Penalty
    ) {
        data class Halftime(
            @SerializedName("home")
            val home: Int,
            @SerializedName("away")
            val away: Int
        )

        data class Fulltime(
            @SerializedName("home")
            val home: Int,
            @SerializedName("away")
            val away: Int
        )

        data class Extratime(
            @SerializedName("home")
            val home: Any,
            @SerializedName("away")
            val away: Any
        )

        data class Penalty(
            @SerializedName("home")
            val home: Any,
            @SerializedName("away")
            val away: Any
        )
    }
}