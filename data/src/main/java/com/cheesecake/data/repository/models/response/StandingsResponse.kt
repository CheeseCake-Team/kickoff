package com.cheesecake.data.repository.models.response


import com.cheesecake.data.repository.models.dto.StandingsMatchStatisticsDTO
import com.cheesecake.data.repository.models.dto.TeamDTO
import com.cheesecake.domain.Entity.Standings
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
            val team: TeamDTO,
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
            val all: StandingsMatchStatisticsDTO,
            @SerializedName("home")
            val home: StandingsMatchStatisticsDTO,
            @SerializedName("away")
            val away: StandingsMatchStatisticsDTO,
            @SerializedName("update")
            val update: String
        )
    }
}

fun StandingsResponse.mapToDomain(): Standings {
    return Standings(
        flag = this.league.flag,
        name = this.league.name,
        played = this.league.standings[0][0].all.played,
        won = this.league.standings[0][0].all.win,
        draw = this.league.standings[0][0].all.draw,
        lose = this.league.standings[0][0].all.lose,
        points = this.league.standings[0][0].points,
    )
}

fun List<StandingsResponse>.mapToDomain():List<Standings>{
    return this.map { it.mapToDomain() }
}