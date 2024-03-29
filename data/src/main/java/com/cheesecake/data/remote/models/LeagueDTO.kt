package com.cheesecake.data.remote.models


import com.google.gson.annotations.SerializedName

data class LeagueDTO(
    @SerializedName("league") val league: LeagueDataDTO,
    @SerializedName("country") val country: CountryDTO,
    @SerializedName("seasons") val seasons: List<Season>
) {
    data class Season(
        @SerializedName("year") val year: Int,
        @SerializedName("start") val start: String,
        @SerializedName("end") val end: String,
        @SerializedName("current") val current: Boolean,
        @SerializedName("coverage") val coverage: Coverage
    ) {
        data class Coverage(
            @SerializedName("fixtures") val fixtures: Fixtures,
            @SerializedName("standings") val standings: Boolean,
            @SerializedName("players") val players: Boolean,
            @SerializedName("top_scorers") val topScorers: Boolean,
            @SerializedName("top_assists") val topAssists: Boolean,
            @SerializedName("top_cards") val topCards: Boolean,
            @SerializedName("injuries") val injuries: Boolean,
            @SerializedName("predictions") val predictions: Boolean,
            @SerializedName("odds") val odds: Boolean
        ) {
            data class Fixtures(
                @SerializedName("events") val events: Boolean,
                @SerializedName("lineups") val lineups: Boolean,
                @SerializedName("statistics_fixtures") val statisticsFixtures: Boolean,
                @SerializedName("statistics_players") val statisticsPlayers: Boolean
            )
        }
    }
}
