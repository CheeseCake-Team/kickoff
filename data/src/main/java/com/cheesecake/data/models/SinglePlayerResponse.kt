package com.cheesecake.data.models

import com.google.gson.annotations.SerializedName

data class SinglePlayerResponse(
    @SerializedName("player")
    val player: Player,
    @SerializedName("statistics")
    val statistics: List<Statistic>
) {
    data class Player(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("firstname")
        val firstname: String,
        @SerializedName("lastname")
        val lastname: String,
        @SerializedName("age")
        val age: Int,
        @SerializedName("birth")
        val birth: Birth,
        @SerializedName("nationality")
        val nationality: String,
        @SerializedName("height")
        val height: String,
        @SerializedName("weight")
        val weight: String,
        @SerializedName("injured")
        val injured: Boolean,
        @SerializedName("photo")
        val photo: String
    ) {
        data class Birth(
            @SerializedName("date")
            val date: String,
            @SerializedName("place")
            val place: String,
            @SerializedName("country")
            val country: String
        )
    }

    data class Statistic(
        @SerializedName("team")
        val team: Team,
        @SerializedName("league")
        val league: League,
        @SerializedName("games")
        val games: Games,
        @SerializedName("substitutes")
        val substitutes: Substitutes,
        @SerializedName("shots")
        val shots: Shots,
        @SerializedName("goals")
        val goals: Goals,
        @SerializedName("passes")
        val passes: Passes,
        @SerializedName("tackles")
        val tackles: Tackles,
        @SerializedName("duels")
        val duels: Duels,
        @SerializedName("dribbles")
        val dribbles: Dribbles,
        @SerializedName("fouls")
        val fouls: Fouls,
        @SerializedName("cards")
        val cards: Cards,
        @SerializedName("penalty")
        val penalty: Penalty
    ) {
        data class Team(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("logo")
            val logo: String
        )

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
            val season: Int
        )

        data class Games(
            @SerializedName("appearences")
            val appearences: Int,
            @SerializedName("lineups")
            val lineups: Int,
            @SerializedName("minutes")
            val minutes: Int,
            @SerializedName("number")
            val number: Any,
            @SerializedName("position")
            val position: String,
            @SerializedName("rating")
            val rating: String,
            @SerializedName("captain")
            val captain: Boolean
        )

        data class Substitutes(
            @SerializedName("in")
            val inX: Int,
            @SerializedName("out")
            val `out`: Int,
            @SerializedName("bench")
            val bench: Int
        )

        data class Shots(
            @SerializedName("total")
            val total: Int,
            @SerializedName("on")
            val on: Int
        )

        data class Goals(
            @SerializedName("total")
            val total: Int,
            @SerializedName("conceded")
            val conceded: Int,
            @SerializedName("assists")
            val assists: Int,
            @SerializedName("saves")
            val saves: Any
        )

        data class Passes(
            @SerializedName("total")
            val total: Int,
            @SerializedName("key")
            val key: Int,
            @SerializedName("accuracy")
            val accuracy: Int
        )

        data class Tackles(
            @SerializedName("total")
            val total: Int,
            @SerializedName("blocks")
            val blocks: Int,
            @SerializedName("interceptions")
            val interceptions: Int
        )

        data class Duels(
            @SerializedName("total")
            val total: Int,
            @SerializedName("won")
            val won: Int
        )

        data class Dribbles(
            @SerializedName("attempts")
            val attempts: Int,
            @SerializedName("success")
            val success: Int,
            @SerializedName("past")
            val past: Any
        )

        data class Fouls(
            @SerializedName("drawn")
            val drawn: Int,
            @SerializedName("committed")
            val committed: Int
        )

        data class Cards(
            @SerializedName("yellow")
            val yellow: Int,
            @SerializedName("yellowred")
            val yellowred: Int,
            @SerializedName("red")
            val red: Int
        )

        data class Penalty(
            @SerializedName("won")
            val won: Any,
            @SerializedName("commited")
            val commited: Any,
            @SerializedName("scored")
            val scored: Int,
            @SerializedName("missed")
            val missed: Int,
            @SerializedName("saved")
            val saved: Any
        )
    }
}