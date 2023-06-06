package com.cheesecake.data.models.dto


import com.cheesecake.data.models.base.LeagueTypeLogo
import com.cheesecake.domain.models.League
import com.cheesecake.domain.models.TeamInformation
import com.google.gson.annotations.SerializedName

data class LeagueDTO(
    @SerializedName("league")
    val league: LeagueTypeLogo,
    @SerializedName("country")
    val country: CountryDto,
    @SerializedName("seasons")
    val seasons: List<Season>
) {
    data class Season(
        @SerializedName("year")
        val year: Int,
        @SerializedName("start")
        val start: String,
        @SerializedName("end")
        val end: String,
        @SerializedName("current")
        val current: Boolean,
        @SerializedName("coverage")
        val coverage: Coverage
    ) {
        data class Coverage(
            @SerializedName("fixtures")
            val fixtures: Fixtures,
            @SerializedName("standings")
            val standings: Boolean,
            @SerializedName("players")
            val players: Boolean,
            @SerializedName("top_scorers")
            val topScorers: Boolean,
            @SerializedName("top_assists")
            val topAssists: Boolean,
            @SerializedName("top_cards")
            val topCards: Boolean,
            @SerializedName("injuries")
            val injuries: Boolean,
            @SerializedName("predictions")
            val predictions: Boolean,
            @SerializedName("odds")
            val odds: Boolean
        ) {
            data class Fixtures(
                @SerializedName("events")
                val events: Boolean,
                @SerializedName("lineups")
                val lineups: Boolean,
                @SerializedName("statistics_fixtures")
                val statisticsFixtures: Boolean,
                @SerializedName("statistics_players")
                val statisticsPlayers: Boolean
            )
        }
    }
}

fun LeagueDTO.mapToDomain(): League {
    return League(
        //TODO implement TeamInformation data class
    )
}

fun List<LeagueDTO>.mapToDomain():List<League>{
    return this.map { it.mapToDomain() }
}