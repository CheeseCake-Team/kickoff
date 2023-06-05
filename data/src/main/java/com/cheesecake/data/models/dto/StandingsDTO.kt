package com.cheesecake.data.models.dto


import com.cheesecake.data.models.base.StandingsMatchStatistics
import com.cheesecake.data.models.base.Team
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
            val all: StandingsMatchStatistics,
            @SerializedName("home")
            val home: StandingsMatchStatistics,
            @SerializedName("away")
            val away: StandingsMatchStatistics,
            @SerializedName("update")
            val update: String
        )
    }
}