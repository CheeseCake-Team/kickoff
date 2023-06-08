package com.cheesecake.data.remote.response


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
            val team: com.cheesecake.data.remote.models.TeamDTO,
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
            val all: com.cheesecake.data.remote.models.StandingsMatchStatisticsDTO,
            @SerializedName("home")
            val home: com.cheesecake.data.remote.models.StandingsMatchStatisticsDTO,
            @SerializedName("away")
            val away: com.cheesecake.data.remote.models.StandingsMatchStatisticsDTO,
            @SerializedName("update")
            val update: String
        )
    }
}
