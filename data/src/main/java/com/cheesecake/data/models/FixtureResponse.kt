package com.cheesecake.data.models


import com.google.gson.annotations.SerializedName

data class FixtureResponse(
    @SerializedName("fixture")
    val fixture: Fixture,
    @SerializedName("league")
    val league: League,
    @SerializedName("teams")
    val teams: Teams,
    @SerializedName("goals")
    val goals: Goals,
    @SerializedName("score")
    val score: Score,
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
        val home: Home,
        @SerializedName("away")
        val away: Away
    ) {
        data class Home(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("logo")
            val logo: String,
            @SerializedName("winner")
            val winner: Boolean
        )

        data class Away(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("logo")
            val logo: String,
            @SerializedName("winner")
            val winner: Boolean
        )
    }

    data class Goals(
        @SerializedName("home")
        val home: Int,
        @SerializedName("away")
        val away: Int
    )

    data class Score(
        @SerializedName("halftime")
        val halftime: Halftime,
        @SerializedName("fulltime")
        val fulltime: Fulltime,
        @SerializedName("extratime")
        val extratime: Extratime,
        @SerializedName("penalty")
        val penalty: Penalty
    ) {
        data class Halftime(
            @SerializedName("home")
            val home: Int,
            @SerializedName("away")
            val away: Int
        )

        data class Fulltime(
            @SerializedName("home")
            val home: Int,
            @SerializedName("away")
            val away: Int
        )

        data class Extratime(
            @SerializedName("home")
            val home: Any,
            @SerializedName("away")
            val away: Any
        )

        data class Penalty(
            @SerializedName("home")
            val home: Any,
            @SerializedName("away")
            val away: Any
        )
    }

    data class Event(
        @SerializedName("time")
        val time: Time,
        @SerializedName("team")
        val team: Team,
        @SerializedName("player")
        val player: Player,
        @SerializedName("assist")
        val assist: Assist,
        @SerializedName("type")
        val type: String,
        @SerializedName("detail")
        val detail: String,
        @SerializedName("comments")
        val comments: String
    ) {
        data class Time(
            @SerializedName("elapsed")
            val elapsed: Int,
            @SerializedName("extra")
            val extra: Any
        )

        data class Team(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("logo")
            val logo: String
        )

        data class Player(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String
        )

        data class Assist(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String
        )
    }

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
            val colors: Colors
        ) {
            data class Colors(
                @SerializedName("player")
                val player: Player,
                @SerializedName("goalkeeper")
                val goalkeeper: Goalkeeper
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
            val player: Player
        ) {
            data class Player(
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String,
                @SerializedName("number")
                val number: Int,
                @SerializedName("pos")
                val pos: String,
                @SerializedName("grid")
                val grid: String
            )
        }

        data class Substitute(
            @SerializedName("player")
            val player: Player
        ) {
            data class Player(
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String,
                @SerializedName("number")
                val number: Int,
                @SerializedName("pos")
                val pos: String,
                @SerializedName("grid")
                val grid: Any
            )
        }
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
                val goals: Goals,
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

                data class Shots(
                    @SerializedName("total")
                    val total: Int,
                    @SerializedName("on")
                    val on: Int
                )

                data class Goals(
                    @SerializedName("total")
                    val total: Int,
                    @SerializedName("conceded")
                    val conceded: Int,
                    @SerializedName("assists")
                    val assists: Int,
                    @SerializedName("saves")
                    val saves: Int
                )

                data class Passes(
                    @SerializedName("total")
                    val total: Int,
                    @SerializedName("key")
                    val key: Int,
                    @SerializedName("accuracy")
                    val accuracy: String
                )

                data class Tackles(
                    @SerializedName("total")
                    val total: Int,
                    @SerializedName("blocks")
                    val blocks: Int,
                    @SerializedName("interceptions")
                    val interceptions: Int
                )

                data class Duels(
                    @SerializedName("total")
                    val total: Int,
                    @SerializedName("won")
                    val won: Int
                )

                data class Dribbles(
                    @SerializedName("attempts")
                    val attempts: Int,
                    @SerializedName("success")
                    val success: Int,
                    @SerializedName("past")
                    val past: Int
                )

                data class Fouls(
                    @SerializedName("drawn")
                    val drawn: Int,
                    @SerializedName("committed")
                    val committed: Int
                )

                data class Cards(
                    @SerializedName("yellow")
                    val yellow: Int,
                    @SerializedName("red")
                    val red: Int
                )

                data class Penalty(
                    @SerializedName("won")
                    val won: Any,
                    @SerializedName("commited")
                    val commited: Any,
                    @SerializedName("scored")
                    val scored: Int,
                    @SerializedName("missed")
                    val missed: Int,
                    @SerializedName("saved")
                    val saved: Int
                )
            }
        }
    }
}