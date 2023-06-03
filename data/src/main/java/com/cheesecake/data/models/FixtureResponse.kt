package com.cheesecake.data.models


import com.cheesecake.data.models.base.BaseGoals
import com.cheesecake.data.models.base.Cards
import com.cheesecake.data.models.base.Dribbles
import com.cheesecake.data.models.base.Duels
import com.cheesecake.data.models.base.Fouls
import com.cheesecake.data.models.base.GoalsState
import com.cheesecake.data.models.base.HomeAway
import com.cheesecake.data.models.base.Passes
import com.cheesecake.data.models.base.Penalty
import com.cheesecake.data.models.base.PlayerMeta
import com.cheesecake.data.models.base.PlayerPosGrid
import com.cheesecake.data.models.base.ScoreBlock
import com.cheesecake.data.models.base.Shots
import com.cheesecake.data.models.base.Tackles
import com.cheesecake.data.models.base.Team
import com.cheesecake.data.models.base.TeamColor
import com.cheesecake.data.models.base.TimeMeta
import com.google.gson.annotations.SerializedName

data class FixtureResponse(
    @SerializedName("fixture")
    val fixture: Fixture,
    @SerializedName("league")
    val league: League,
    @SerializedName("teams")
    val teams: Teams,
    @SerializedName("goals")
    val goals: BaseGoals,
    @SerializedName("score")
    val score: ScoreBlock,
    @SerializedName("events")
    val events: List<Event>,
    @SerializedName("lineups")
    val lineups: List<Lineup>,
    @SerializedName("statistics")
    val statistics: List<Statistic>,
    @SerializedName("players")
    val players: List<Player>
) {
    data class Fixture(
        @SerializedName("id")
        val id: Int,
        @SerializedName("referee")
        val referee: String,
        @SerializedName("timezone")
        val timezone: String,
        @SerializedName("date")
        val date: String,
        @SerializedName("timestamp")
        val timestamp: Int,
        @SerializedName("periods")
        val periods: Periods,
        @SerializedName("venue")
        val venue: Venue,
        @SerializedName("status")
        val status: Status
    ) {
        data class Periods(
            @SerializedName("first")
            val first: Int,
            @SerializedName("second")
            val second: Int
        )

        data class Venue(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("city")
            val city: String
        )

        data class Status(
            @SerializedName("long")
            val long: String,
            @SerializedName("short")
            val short: String,
            @SerializedName("elapsed")
            val elapsed: Int
        )
    }

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
        @SerializedName("round")
        val round: String
    )

    data class Teams(
        @SerializedName("home")
        val home: HomeAway,
        @SerializedName("away")
        val away: HomeAway
    )

    data class Event(
        @SerializedName("time")
        val time: TimeMeta,
        @SerializedName("team")
        val team: Team,
        @SerializedName("player")
        val player: PlayerMeta,
        @SerializedName("assist")
        val assist: PlayerMeta,
        @SerializedName("type")
        val type: String,
        @SerializedName("detail")
        val detail: String,
        @SerializedName("comments")
        val comments: String
    )

    data class Lineup(
        @SerializedName("team")
        val team: Team,
        @SerializedName("coach")
        val coach: Coach,
        @SerializedName("formation")
        val formation: String,
        @SerializedName("startXI")
        val startXI: List<StartXI>,
        @SerializedName("substitutes")
        val substitutes: List<Substitute>
    ) {
        data class Team(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("logo")
            val logo: String,
            @SerializedName("colors")
            val colors: TeamColor
        ) {
                data class Player(
                    @SerializedName("primary")
                    val primary: String,
                    @SerializedName("number")
                    val number: String,
                    @SerializedName("border")
                    val border: String
                )

                data class Goalkeeper(
                    @SerializedName("primary")
                    val primary: String,
                    @SerializedName("number")
                    val number: String,
                    @SerializedName("border")
                    val border: String
                )
            }
        }

        data class Coach(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("photo")
            val photo: String
        )

        data class StartXI(
            @SerializedName("player")
            val player: PlayerPosGrid
        )

        data class Substitute(
            @SerializedName("player")
            val player: PlayerPosGrid
        )
    }
    data class Statistic(
        @SerializedName("team")
        val team: Team,
        @SerializedName("statistics")
        val statistics: List<Statistic>
    ) {
        data class Team(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("logo")
            val logo: String
        )

        data class Statistic(
            @SerializedName("type")
            val type: String,
            @SerializedName("value")
            val value: Int
        )
    }

    data class Player(
        @SerializedName("team")
        val team: Team,
        @SerializedName("players")
        val players: List<Player>
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
            val player: Player,
            @SerializedName("statistics")
            val statistics: List<Statistic>
        ) {
            data class Player(
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String,
                @SerializedName("photo")
                val photo: String
            )

            data class Statistic(
                @SerializedName("games")
                val games: Games,
                @SerializedName("offsides")
                val offsides: Int,
                @SerializedName("shots")
                val shots: Shots,
                @SerializedName("goals")
                val goals: GoalsState,
                @SerializedName("passes")
                val passes: Passes,
                @SerializedName("tackles")
                val tackles: Tackles,
                @SerializedName("duels")
                val duels: Duels,
                @SerializedName("dribbles")
                val dribbles: Dribbles,
                @SerializedName("fouls")
                val fouls: Fouls,
                @SerializedName("cards")
                val cards: Cards,
                @SerializedName("penalty")
                val penalty: Penalty
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
