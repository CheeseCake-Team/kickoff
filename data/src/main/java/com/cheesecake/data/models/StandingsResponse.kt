package com.cheesecake.data.models


import com.google.gson.annotations.SerializedName

data class StandingsResponse(
    @SerializedName("league")
    val league: League
) {
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
        @SerializedName("standings")
        val standings: List<List<Standing>>
    ) {
        data class Standing(
            @SerializedName("rank")
            val rank: Int,
            @SerializedName("team")
            val team: Team,
            @SerializedName("points")
            val points: Int,
            @SerializedName("goalsDiff")
            val goalsDiff: Int,
            @SerializedName("group")
            val group: String,
            @SerializedName("form")
            val form: String,
            @SerializedName("status")
            val status: String,
            @SerializedName("description")
            val description: String,
            @SerializedName("all")
            val all: All,
            @SerializedName("home")
            val home: Home,
            @SerializedName("away")
            val away: Away,
            @SerializedName("update")
            val update: String
        ) {
            data class Team(
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String,
                @SerializedName("logo")
                val logo: String
            )

            data class All(
                @SerializedName("played")
                val played: Int,
                @SerializedName("win")
                val win: Int,
                @SerializedName("draw")
                val draw: Int,
                @SerializedName("lose")
                val lose: Int,
                @SerializedName("goals")
                val goals: Goals
            ) {
                data class Goals(
                    @SerializedName("for")
                    val forX: Int,
                    @SerializedName("against")
                    val against: Int
                )
            }
            data class Home(
                @SerializedName("played")
                val played: Int,
                @SerializedName("win")
                val win: Int,
                @SerializedName("draw")
                val draw: Int,
                @SerializedName("lose")
                val lose: Int,
                @SerializedName("goals")
                val goals: Goals
            ) {
                data class Goals(
                    @SerializedName("for")
                    val forX: Int,
                    @SerializedName("against")
                    val against: Int
                )
            }
            data class Away(
                @SerializedName("played")
                val played: Int,
                @SerializedName("win")
                val win: Int,
                @SerializedName("draw")
                val draw: Int,
                @SerializedName("lose")
                val lose: Int,
                @SerializedName("goals")
                val goals: Goals
            ) {
                data class Goals(
                    @SerializedName("for")
                    val forX: Int,
                    @SerializedName("against")
                    val against: Int
                )
            }
        }
    }
}