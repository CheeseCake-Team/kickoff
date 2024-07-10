package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class StandingsDTO(
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
        val standings: List<List<Standing>>,
        @SerializedName("goals")
        val goals : GoalsForAgainstDTO
    ) {
        data class Standing(
            @SerializedName("rank")
            val rank: Int,
            @SerializedName("team")
            val team: TeamDataDTO,
            @SerializedName("points")
            val points: Int,
            @SerializedName("goalsDiff")
            val goalsDiff: Int,
            @SerializedName("group")
            val group: String,
            @SerializedName("form")
            val form: String?,
            @SerializedName("status")
            val status: String,
            @SerializedName("description")
            val description: String,
            @SerializedName("all")
            val all: StandingsMatchStatisticsDTO,
            @SerializedName("home")
            val home: StandingsMatchStatisticsDTO,
            @SerializedName("away")
            val away: StandingsMatchStatisticsDTO,
            @SerializedName("update")
            val update: String,

        )
    }
}
