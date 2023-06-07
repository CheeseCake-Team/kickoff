package com.cheesecake.data.repository.models.response


import com.cheesecake.data.repository.models.dto.LeagueTypeLogoDTO
import com.cheesecake.domain.Entity.League
import com.google.gson.annotations.SerializedName

data class LeagueResponse(
    @SerializedName("league")
    val league: LeagueTypeLogoDTO,
    @SerializedName("country")
    val country: CountryResponse,
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

fun LeagueResponse.mapToDomain(): League {
    return League(
        leagueId = this.league.id,
        leagueName = this.league.name,
        leagueSeason = this.seasons.first().year.toString(),
        leagueLogo = this.league.logo,
        seasonStartYear = this.seasons.first().start.substring(0, 4),
        seasonEndYear = this.seasons.first().end.substring(0, 4),
        isFavourite = false
    )
}

fun List<LeagueResponse>.mapToDomain():List<League>{
    return this.map { it.mapToDomain() }
}

fun LeagueResponse.mapToLocal(): LeagueResponse {
    return LeagueResponse(
        leagueId = this.league.id,
        leagueName = this.league.name,
        leagueSeason = this.seasons.first().year.toString(),
        leagueLogoUrl = this.league.logo,
        seasonStartYear = this.seasons.first().start,
        seasonEndYear = this.seasons.first().end,
        isFavourite = false
    )
}

fun List<LeagueResponse>.mapToLocal(): List<LeagueResponse>{
    return this.map { it.mapToLocal() }
}