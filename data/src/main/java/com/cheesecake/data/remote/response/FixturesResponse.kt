package com.cheesecake.data.remote.response

import com.cheesecake.data.remote.models.BaseGoalsDTO
import com.cheesecake.data.remote.models.CardsDTO
import com.cheesecake.data.remote.models.DribblesDTO
import com.cheesecake.data.remote.models.DuelsDTO
import com.cheesecake.data.remote.models.FixtureDTO
import com.cheesecake.data.remote.models.FoulsDTO
import com.cheesecake.data.remote.models.GoalsStateDTO
import com.cheesecake.data.remote.models.LeagueCountrySeasonRoundDTO
import com.cheesecake.data.remote.models.PassesDTO
import com.cheesecake.data.remote.models.PenaltyDTO
import com.cheesecake.data.remote.models.PersonPhotoDTO
import com.cheesecake.data.remote.models.PlayerColorDTO
import com.cheesecake.data.remote.models.PlayerMetaDTO
import com.cheesecake.data.remote.models.PlayerPosGridDTO
import com.cheesecake.data.remote.models.ScoreBlockDTO
import com.cheesecake.data.remote.models.ShotsDTO
import com.cheesecake.data.remote.models.TacklesDTO
import com.cheesecake.data.remote.models.TeamDTO
import com.cheesecake.data.remote.models.TeamHomeAwayDTO
import com.cheesecake.data.remote.models.TimeMetaDTO
import com.google.gson.annotations.SerializedName

data class FixturesResponse(
    @SerializedName("fixture")
    val fixtureDTO: com.cheesecake.data.remote.models.FixtureDTO,
    @SerializedName("league")
    val league: com.cheesecake.data.remote.models.LeagueCountrySeasonRoundDTO,
    @SerializedName("teams")
    val teams: com.cheesecake.data.remote.models.TeamHomeAwayDTO,
    @SerializedName("goals")
    val goals: com.cheesecake.data.remote.models.BaseGoalsDTO,
    @SerializedName("score")
    val score: com.cheesecake.data.remote.models.ScoreBlockDTO,
    @SerializedName("events")
    val events: List<com.cheesecake.data.remote.response.FixturesResponse.Event>,
    @SerializedName("lineups")
    val lineups: List<com.cheesecake.data.remote.response.FixturesResponse.Lineup>,
    @SerializedName("statistics")
    val statistics: List<com.cheesecake.data.remote.response.FixturesResponse.Statistic>,
    @SerializedName("players")
    val players: List<com.cheesecake.data.remote.response.FixturesResponse.Player>
) {
    data class Event(
        @SerializedName("time")
        val time: com.cheesecake.data.remote.models.TimeMetaDTO,
        @SerializedName("team")
        val team: com.cheesecake.data.remote.models.TeamDTO,
        @SerializedName("player")
        val player: com.cheesecake.data.remote.models.PlayerMetaDTO,
        @SerializedName("assist")
        val assist: com.cheesecake.data.remote.models.PlayerMetaDTO,
        @SerializedName("type")
        val type: String,
        @SerializedName("detail")
        val detail: String,
        @SerializedName("comments")
        val comments: String
    )

    data class Lineup(
        @SerializedName("team")
        val team: com.cheesecake.data.remote.response.FixturesResponse.Lineup.Team,
        @SerializedName("coach")
        val coach: com.cheesecake.data.remote.models.PersonPhotoDTO,
        @SerializedName("formation")
        val formation: String,
        @SerializedName("startXI")
        val startXI: List<com.cheesecake.data.remote.response.FixturesResponse.StartXI>,
        @SerializedName("substitutes")
        val substitutes: List<com.cheesecake.data.remote.response.FixturesResponse.Substitute>
    ) {
        data class Team(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("logo")
            val logo: String,
            @SerializedName("colors")
            val colors: com.cheesecake.data.remote.models.PlayerColorDTO
        )
    }

    data class StartXI(
        @SerializedName("player")
        val player: com.cheesecake.data.remote.models.PlayerPosGridDTO
    )

    data class Substitute(
        @SerializedName("player")
        val player: com.cheesecake.data.remote.models.PlayerPosGridDTO
    )

    data class Statistic(
        @SerializedName("team")
        val team: com.cheesecake.data.remote.models.TeamDTO,
        @SerializedName("statistics")
        val statistics: List<com.cheesecake.data.remote.response.FixturesResponse.Statistic.Statistic>
    ) {
        data class Statistic(
            @SerializedName("type")
            val type: String,
            @SerializedName("value")
            val value: Int
        )
    }

    data class Player(
        @SerializedName("team")
        val team: com.cheesecake.data.remote.response.FixturesResponse.Player.Team,
        @SerializedName("players")
        val players: List<com.cheesecake.data.remote.response.FixturesResponse.Player.Player>
    ) {
        data class Team(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("logo")
            val logo: String,
            @SerializedName("update")
            val update: String
        )

        data class Player(
            @SerializedName("player")
            val player: com.cheesecake.data.remote.models.PersonPhotoDTO,
            @SerializedName("statistics")
            val statistics: List<com.cheesecake.data.remote.response.FixturesResponse.Player.Player.Statistic>
        ) {
            data class Statistic(
                @SerializedName("games")
                val games: com.cheesecake.data.remote.response.FixturesResponse.Player.Player.Statistic.Games,
                @SerializedName("offsides")
                val offsides: Int,
                @SerializedName("shots")
                val shots: com.cheesecake.data.remote.models.ShotsDTO,
                @SerializedName("goals")
                val goals: com.cheesecake.data.remote.models.GoalsStateDTO,
                @SerializedName("passes")
                val passes: com.cheesecake.data.remote.models.PassesDTO,
                @SerializedName("tackles")
                val tackles: com.cheesecake.data.remote.models.TacklesDTO,
                @SerializedName("duels")
                val duels: com.cheesecake.data.remote.models.DuelsDTO,
                @SerializedName("dribbles")
                val dribbles: com.cheesecake.data.remote.models.DribblesDTO,
                @SerializedName("fouls")
                val fouls: com.cheesecake.data.remote.models.FoulsDTO,
                @SerializedName("cards")
                val cards: com.cheesecake.data.remote.models.CardsDTO,
                @SerializedName("penalty")
                val penalty: com.cheesecake.data.remote.models.PenaltyDTO
            ) {
                data class Games(
                    @SerializedName("minutes")
                    val minutes: Int,
                    @SerializedName("number")
                    val number: Int,
                    @SerializedName("position")
                    val position: String,
                    @SerializedName("rating")
                    val rating: String,
                    @SerializedName("captain")
                    val captain: Boolean,
                    @SerializedName("substitute")
                    val substitute: Boolean
                )
            }
        }
    }
}

