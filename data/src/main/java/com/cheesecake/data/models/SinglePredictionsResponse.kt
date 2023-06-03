package com.cheesecake.data.models


import com.cheesecake.data.models.base.GoalAvgTotal
import com.cheesecake.data.models.base.LeagueCountrySeason
import com.cheesecake.data.models.base.LeagueCountrySeasonRound
import com.cheesecake.data.models.base.MatchAvgTotal
import com.cheesecake.data.models.base.MatchesTotal
import com.cheesecake.data.models.base.Minute0105
import com.cheesecake.data.models.base.PenaltyTotal
import com.cheesecake.data.models.base.PercentageTotal
import com.cheesecake.data.models.base.ScoreBlock
import com.cheesecake.data.models.base.Matches
import com.cheesecake.data.models.base.ScoreStatusString
import com.cheesecake.data.models.base.TeamHomeAway
import com.google.gson.annotations.SerializedName

data class SinglePredictionsResponse(
    @SerializedName("comparison")
    val comparison: Comparison,
    @SerializedName("h2h")
    val h2h: List<H2h>,
    @SerializedName("league")
    val league: LeagueCountrySeason,
    @SerializedName("predictions")
    val predictions: Predictions,
    @SerializedName("teams")
    val teams: Teams
) {
    data class Comparison(
        @SerializedName("att")
        val att: ScoreStatusString,
        @SerializedName("def")
        val def: ScoreStatusString,
        @SerializedName("form")
        val form: ScoreStatusString,
        @SerializedName("goals")
        val goals: ScoreStatusString,
        @SerializedName("h2h")
        val h2h: ScoreStatusString,
        @SerializedName("poisson_distribution")
        val poissonDistribution: ScoreStatusString,
        @SerializedName("total")
        val total: ScoreStatusString
    )

    ///////////////////////////////////////////////////////////////////
    data class H2h(
        @SerializedName("fixture")
        val fixture: Fixture,
        @SerializedName("goals")
        val goals: Matches,
        @SerializedName("league")
        val league: LeagueCountrySeasonRound,
        @SerializedName("score")
        val score: ScoreBlock,
        @SerializedName("teams")
        val teams: TeamHomeAway
    ) {
        data class Fixture(
            @SerializedName("date")
            val date: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("periods")
            val periods: Periods,
            @SerializedName("referee")
            val referee: String,
            @SerializedName("status")
            val status: Status,
            @SerializedName("timestamp")
            val timestamp: Int,
            @SerializedName("timezone")
            val timezone: String,
            @SerializedName("venue")
            val venue: Venue
        ) {
            data class Periods(
                @SerializedName("first")
                val first: Int,
                @SerializedName("second")
                val second: Int
            )

            data class Status(
                @SerializedName("elapsed")
                val elapsed: Int,
                @SerializedName("long")
                val long: String,
                @SerializedName("short")
                val short: String
            )

            data class Venue(
                @SerializedName("city")
                val city: Any,
                @SerializedName("id")
                val id: Any,
                @SerializedName("name")
                val name: String
            )
        }
    }


    data class Predictions(
        @SerializedName("advice")
        val advice: String,
        @SerializedName("goals")
        val goals: Matches,
        @SerializedName("percent")
        val percent: Percent,
        @SerializedName("under_over")
        val underOver: String,
        @SerializedName("win_or_draw")
        val winOrDraw: Boolean,
        @SerializedName("winner")
        val winner: Winner
    ) {

        data class Percent(
            @SerializedName("away")
            val away: String,
            @SerializedName("draw")
            val draw: String,
            @SerializedName("home")
            val home: String
        )

        data class Winner(
            @SerializedName("comment")
            val comment: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String
        )
    }

    data class Teams(
        @SerializedName("away")
        val away: Away,
        @SerializedName("home")
        val home: Home
    ) {
        data class Away(
            @SerializedName("id")
            val id: Int,
            @SerializedName("last_5")
            val last5: Last5,
            @SerializedName("league")
            val league: League,
            @SerializedName("logo")
            val logo: String,
            @SerializedName("name")
            val name: String
        ) {
            data class Last5(
                @SerializedName("att")
                val att: String,
                @SerializedName("def")
                val def: String,
                @SerializedName("form")
                val form: String,
                @SerializedName("goals")
                val goals: Goals
            ) {
                data class Goals(
                    @SerializedName("against")
                    val against: MatchAvgTotal,
                    @SerializedName("for")
                    val forX: MatchAvgTotal
                )
            }

            data class League(
                @SerializedName("biggest")
                val biggest: Biggest,
                @SerializedName("cards")
                val cards: Cards,
                @SerializedName("clean_sheet")
                val cleanSheet: MatchesTotal,
                @SerializedName("failed_to_score")
                val failedToScore: MatchesTotal,
                @SerializedName("fixtures")
                val fixtures: Fixtures,
                @SerializedName("form")
                val form: String,
                @SerializedName("goals")
                val goals: Goals,
                @SerializedName("lineups")
                val lineups: List<Any>,
                @SerializedName("penalty")
                val penalty: Penalty
            ) {
                data class Biggest(
                    @SerializedName("goals")
                    val goals: Goals,
                    @SerializedName("loses")
                    val loses: Matches,
                    @SerializedName("streak")
                    val streak: Streak,
                    @SerializedName("wins")
                    val wins: Matches
                ) {
                    data class Goals(
                        @SerializedName("against")
                        val against: Matches,
                        @SerializedName("for")
                        val forX: Matches
                    )
                    data class Streak(
                        @SerializedName("draws")
                        val draws: Int,
                        @SerializedName("loses")
                        val loses: Int,
                        @SerializedName("wins")
                        val wins: Int
                    )
                }

                data class Cards(
                    @SerializedName("red")
                    val red: Minute0105,
                    @SerializedName("yellow")
                    val yellow: Minute0105
                )

                data class Fixtures(
                    @SerializedName("draws")
                    val draws: MatchesTotal,
                    @SerializedName("loses")
                    val loses: MatchesTotal,
                    @SerializedName("played")
                    val played: MatchesTotal,
                    @SerializedName("wins")
                    val wins: MatchesTotal
                )

                data class Goals(
                    @SerializedName("against")
                    val against: GoalAvgTotal,
                    @SerializedName("for")
                    val forX: GoalAvgTotal
                )

                data class Penalty(
                    @SerializedName("missed")
                    val missed: PercentageTotal,
                    @SerializedName("scored")
                    val scored: PercentageTotal,
                    @SerializedName("total")
                    val total: Int
                )
            }
        }

        data class Home(
            @SerializedName("id")
            val id: Int,
            @SerializedName("last_5")
            val last5: Last5,
            @SerializedName("league")
            val league: League,
            @SerializedName("logo")
            val logo: String,
            @SerializedName("name")
            val name: String
        ) {
            data class Last5(
                @SerializedName("att")
                val att: String,
                @SerializedName("def")
                val def: String,
                @SerializedName("form")
                val form: String,
                @SerializedName("goals")
                val goals: Goals
            ) {
                data class Goals(
                    @SerializedName("against")
                    val against: MatchAvgTotal,
                    @SerializedName("for")
                    val forX: MatchAvgTotal
                )
            }

            data class League(
                @SerializedName("biggest")
                val biggest: Biggest,
                @SerializedName("cards")
                val cards: Cards,
                @SerializedName("clean_sheet")
                val cleanSheet: MatchesTotal,
                @SerializedName("failed_to_score")
                val failedToScore: MatchesTotal,
                @SerializedName("fixtures")
                val fixtures: Fixtures,
                @SerializedName("form")
                val form: String,
                @SerializedName("goals")
                val goals: Goals,
                @SerializedName("lineups")
                val lineups: List<Any>,
                @SerializedName("penalty")
                val penalty: PenaltyTotal
            ) {
                data class Biggest(
                    @SerializedName("goals")
                    val goals: Goals,
                    @SerializedName("loses")
                    val loses: Matches,
                    @SerializedName("streak")
                    val streak: Streak,
                    @SerializedName("wins")
                    val wins: Matches
                ) {
                    data class Goals(
                        @SerializedName("against")
                        val against: Matches,
                        @SerializedName("for")
                        val forX: Matches
                    )
                    data class Streak(
                        @SerializedName("draws")
                        val draws: Int,
                        @SerializedName("loses")
                        val loses: Int,
                        @SerializedName("wins")
                        val wins: Int
                    )
                }

                data class Cards(
                    @SerializedName("red")
                    val red: Minute0105,
                    @SerializedName("yellow")
                    val yellow: Minute0105
                )
                data class Fixtures(
                    @SerializedName("draws")
                    val draws: MatchesTotal,
                    @SerializedName("loses")
                    val loses: MatchesTotal,
                    @SerializedName("played")
                    val played: MatchesTotal,
                    @SerializedName("wins")
                    val wins: MatchesTotal
                )
                data class Goals(
                    @SerializedName("against")
                    val against: GoalAvgTotal,
                    @SerializedName("for")
                    val forX: GoalAvgTotal
                )
            }
        }
    }
}