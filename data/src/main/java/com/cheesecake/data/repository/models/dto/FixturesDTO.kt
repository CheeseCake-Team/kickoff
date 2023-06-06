package com.cheesecake.data.repository.models.dto

import com.cheesecake.data.repository.models.base.BaseGoals
import com.cheesecake.data.repository.models.base.Cards
import com.cheesecake.data.repository.models.base.PersonPhoto
import com.cheesecake.data.repository.models.base.Dribbles
import com.cheesecake.data.repository.models.base.Duels
import com.cheesecake.data.repository.models.base.Fixture
import com.cheesecake.data.repository.models.base.Fouls
import com.cheesecake.data.repository.models.base.GoalsState
import com.cheesecake.data.repository.models.base.LeagueCountrySeasonRound
import com.cheesecake.data.repository.models.base.Passes
import com.cheesecake.data.repository.models.base.Penalty
import com.cheesecake.data.repository.models.base.PlayerColor
import com.cheesecake.data.repository.models.base.PlayerMeta
import com.cheesecake.data.repository.models.base.PlayerPosGrid
import com.cheesecake.data.repository.models.base.ScoreBlock
import com.cheesecake.data.repository.models.base.Shots
import com.cheesecake.data.repository.models.base.Tackles
import com.cheesecake.data.repository.models.base.Team
import com.cheesecake.data.repository.models.base.TeamHomeAway
import com.cheesecake.data.repository.models.base.TimeMeta
import com.google.gson.annotations.SerializedName

data class FixturesDTO(
    @SerializedName("fixture")
    val fixture: com.cheesecake.data.repository.models.base.Fixture,
    @SerializedName("league")
    val league: com.cheesecake.data.repository.models.base.LeagueCountrySeasonRound,
    @SerializedName("teams")
    val teams: com.cheesecake.data.repository.models.base.TeamHomeAway,
    @SerializedName("goals")
    val goals: com.cheesecake.data.repository.models.base.BaseGoals,
    @SerializedName("score")
    val score: com.cheesecake.data.repository.models.base.ScoreBlock,
    @SerializedName("events")
    val events: List<com.cheesecake.data.repository.models.dto.FixturesDTO.Event>,
    @SerializedName("lineups")
    val lineups: List<com.cheesecake.data.repository.models.dto.FixturesDTO.Lineup>,
    @SerializedName("statistics")
    val statistics: List<com.cheesecake.data.repository.models.dto.FixturesDTO.Statistic>,
    @SerializedName("players")
    val players: List<com.cheesecake.data.repository.models.dto.FixturesDTO.Player>
) {
    data class Event(
        @SerializedName("time")
        val time: com.cheesecake.data.repository.models.base.TimeMeta,
        @SerializedName("team")
        val team: com.cheesecake.data.repository.models.base.Team,
        @SerializedName("player")
        val player: com.cheesecake.data.repository.models.base.PlayerMeta,
        @SerializedName("assist")
        val assist: com.cheesecake.data.repository.models.base.PlayerMeta,
        @SerializedName("type")
        val type: String,
        @SerializedName("detail")
        val detail: String,
        @SerializedName("comments")
        val comments: String
    )

    data class Lineup(
        @SerializedName("team")
        val team: com.cheesecake.data.repository.models.dto.FixturesDTO.Lineup.Team,
        @SerializedName("coach")
        val coach: com.cheesecake.data.repository.models.base.PersonPhoto,
        @SerializedName("formation")
        val formation: String,
        @SerializedName("startXI")
        val startXI: List<com.cheesecake.data.repository.models.dto.FixturesDTO.StartXI>,
        @SerializedName("substitutes")
        val substitutes: List<com.cheesecake.data.repository.models.dto.FixturesDTO.Substitute>
    ) {
        data class Team(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("logo")
            val logo: String,
            @SerializedName("colors")
            val colors: com.cheesecake.data.repository.models.base.PlayerColor
        )
    }

    data class StartXI(
        @SerializedName("player")
        val player: com.cheesecake.data.repository.models.base.PlayerPosGrid
    )

    data class Substitute(
        @SerializedName("player")
        val player: com.cheesecake.data.repository.models.base.PlayerPosGrid
    )

    data class Statistic(
        @SerializedName("team")
        val team: com.cheesecake.data.repository.models.base.Team,
        @SerializedName("statistics")
        val statistics: List<com.cheesecake.data.repository.models.dto.FixturesDTO.Statistic.Statistic>
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
        val team: com.cheesecake.data.repository.models.dto.FixturesDTO.Player.Team,
        @SerializedName("players")
        val players: List<com.cheesecake.data.repository.models.dto.FixturesDTO.Player.Player>
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
            val player: com.cheesecake.data.repository.models.base.PersonPhoto,
            @SerializedName("statistics")
            val statistics: List<com.cheesecake.data.repository.models.dto.FixturesDTO.Player.Player.Statistic>
        ) {
            data class Statistic(
                @SerializedName("games")
                val games: com.cheesecake.data.repository.models.dto.FixturesDTO.Player.Player.Statistic.Games,
                @SerializedName("offsides")
                val offsides: Int,
                @SerializedName("shots")
                val shots: com.cheesecake.data.repository.models.base.Shots,
                @SerializedName("goals")
                val goals: com.cheesecake.data.repository.models.base.GoalsState,
                @SerializedName("passes")
                val passes: com.cheesecake.data.repository.models.base.Passes,
                @SerializedName("tackles")
                val tackles: com.cheesecake.data.repository.models.base.Tackles,
                @SerializedName("duels")
                val duels: com.cheesecake.data.repository.models.base.Duels,
                @SerializedName("dribbles")
                val dribbles: com.cheesecake.data.repository.models.base.Dribbles,
                @SerializedName("fouls")
                val fouls: com.cheesecake.data.repository.models.base.Fouls,
                @SerializedName("cards")
                val cards: com.cheesecake.data.repository.models.base.Cards,
                @SerializedName("penalty")
                val penalty: com.cheesecake.data.repository.models.base.Penalty
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

