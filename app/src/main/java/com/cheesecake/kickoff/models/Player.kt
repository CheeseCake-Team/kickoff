package com.cheesecake.kickoff.models


import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("errors")
    val errors: List<Any?>? = listOf(),
    @SerializedName("get")
    val `get`: String? = "",
    @SerializedName("paging")
    val paging: Paging? = Paging(),
    @SerializedName("parameters")
    val parameters: Parameters? = Parameters(),
    @SerializedName("response")
    val response: List<Response?>? = listOf(),
    @SerializedName("results")
    val results: Int? = 0
) {
    data class Paging(
        @SerializedName("current")
        val current: Int? = 0,
        @SerializedName("total")
        val total: Int? = 0
    )

    data class Parameters(
        @SerializedName("id")
        val id: String? = "",
        @SerializedName("season")
        val season: String? = ""
    )

    data class Response(
        @SerializedName("player")
        val player: Player? = Player(),
        @SerializedName("statistics")
        val statistics: List<Statistic?>? = listOf()
    ) {
        data class Player(
            @SerializedName("age")
            val age: Int? = 0,
            @SerializedName("birth")
            val birth: Birth? = Birth(),
            @SerializedName("firstname")
            val firstname: String? = "",
            @SerializedName("height")
            val height: String? = "",
            @SerializedName("id")
            val id: Int? = 0,
            @SerializedName("injured")
            val injured: Boolean? = false,
            @SerializedName("lastname")
            val lastname: String? = "",
            @SerializedName("name")
            val name: String? = "",
            @SerializedName("nationality")
            val nationality: String? = "",
            @SerializedName("photo")
            val photo: String? = "",
            @SerializedName("weight")
            val weight: String? = ""
        ) {
            data class Birth(
                @SerializedName("country")
                val country: String? = "",
                @SerializedName("date")
                val date: String? = "",
                @SerializedName("place")
                val place: String? = ""
            )
        }

        data class Statistic(
            @SerializedName("cards")
            val cards: Cards? = Cards(),
            @SerializedName("dribbles")
            val dribbles: Dribbles? = Dribbles(),
            @SerializedName("duels")
            val duels: Duels? = Duels(),
            @SerializedName("fouls")
            val fouls: Fouls? = Fouls(),
            @SerializedName("games")
            val games: Games? = Games(),
            @SerializedName("goals")
            val goals: Goals? = Goals(),
            @SerializedName("league")
            val league: League? = League(),
            @SerializedName("passes")
            val passes: Passes? = Passes(),
            @SerializedName("penalty")
            val penalty: Penalty? = Penalty(),
            @SerializedName("shots")
            val shots: Shots? = Shots(),
            @SerializedName("substitutes")
            val substitutes: Substitutes? = Substitutes(),
            @SerializedName("tackles")
            val tackles: Tackles? = Tackles(),
            @SerializedName("team")
            val team: Team? = Team()
        ) {
            data class Cards(
                @SerializedName("red")
                val red: Int? = 0,
                @SerializedName("yellow")
                val yellow: Int? = 0,
                @SerializedName("yellowred")
                val yellowred: Int? = 0
            )

            data class Dribbles(
                @SerializedName("attempts")
                val attempts: Int? = 0,
                @SerializedName("past")
                val past: Any? = Any(),
                @SerializedName("success")
                val success: Int? = 0
            )

            data class Duels(
                @SerializedName("total")
                val total: Int? = 0,
                @SerializedName("won")
                val won: Int? = 0
            )

            data class Fouls(
                @SerializedName("committed")
                val committed: Int? = 0,
                @SerializedName("drawn")
                val drawn: Int? = 0
            )

            data class Games(
                @SerializedName("appearences")
                val appearences: Int? = 0,
                @SerializedName("captain")
                val captain: Boolean? = false,
                @SerializedName("lineups")
                val lineups: Int? = 0,
                @SerializedName("minutes")
                val minutes: Int? = 0,
                @SerializedName("number")
                val number: Any? = Any(),
                @SerializedName("position")
                val position: String? = "",
                @SerializedName("rating")
                val rating: String? = ""
            )

            data class Goals(
                @SerializedName("assists")
                val assists: Int? = 0,
                @SerializedName("conceded")
                val conceded: Any? = Any(),
                @SerializedName("saves")
                val saves: Any? = Any(),
                @SerializedName("total")
                val total: Int? = 0
            )

            data class League(
                @SerializedName("country")
                val country: String? = "",
                @SerializedName("flag")
                val flag: String? = "",
                @SerializedName("id")
                val id: Int? = 0,
                @SerializedName("logo")
                val logo: String? = "",
                @SerializedName("name")
                val name: String? = "",
                @SerializedName("season")
                val season: Int? = 0
            )

            data class Passes(
                @SerializedName("accuracy")
                val accuracy: Int? = 0,
                @SerializedName("key")
                val key: Int? = 0,
                @SerializedName("total")
                val total: Int? = 0
            )

            data class Penalty(
                @SerializedName("commited")
                val commited: Any? = Any(),
                @SerializedName("missed")
                val missed: Int? = 0,
                @SerializedName("saved")
                val saved: Any? = Any(),
                @SerializedName("scored")
                val scored: Int? = 0,
                @SerializedName("won")
                val won: Int? = 0
            )

            data class Shots(
                @SerializedName("on")
                val on: Int? = 0,
                @SerializedName("total")
                val total: Int? = 0
            )

            data class Substitutes(
                @SerializedName("bench")
                val bench: Int? = 0,
                @SerializedName("in")
                val inX: Int? = 0,
                @SerializedName("out")
                val `out`: Int? = 0
            )

            data class Tackles(
                @SerializedName("blocks")
                val blocks: Int? = 0,
                @SerializedName("interceptions")
                val interceptions: Int? = 0,
                @SerializedName("total")
                val total: Int? = 0
            )

            data class Team(
                @SerializedName("id")
                val id: Int? = 0,
                @SerializedName("logo")
                val logo: String? = "",
                @SerializedName("name")
                val name: String? = ""
            )
        }
    }
}