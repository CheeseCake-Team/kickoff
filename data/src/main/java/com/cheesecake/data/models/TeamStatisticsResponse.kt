package com.cheesecake.data.models

import com.google.gson.annotations.SerializedName

data class TeamStatisticsResponse(
    @SerializedName("league") val league: League,
    @SerializedName("team") val team: Team,
    @SerializedName("form") val form: String,
    @SerializedName("fixtures") val fixtures: Fixtures,
    @SerializedName("goals") val goals: Goals,
    @SerializedName("biggest") val biggest: Biggest,
    @SerializedName("clean_sheet") val cleanSheet: CleanSheet,
    @SerializedName("failed_to_score") val failedToScore: FailedToScore,
    @SerializedName("penalty") val penalty: Penalty,
    @SerializedName("lineups") val lineups: List<Lineup>,
    @SerializedName("cards") val cards: Cards
) {
    data class League(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("country") val country: String,
        @SerializedName("logo") val logo: String,
        @SerializedName("flag") val flag: String,
        @SerializedName("season") val season: Int
    )

    data class Team(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("logo") val logo: String
    )

    data class Fixtures(
        @SerializedName("played") val played: Played,
        @SerializedName("wins") val wins: Wins,
        @SerializedName("draws") val draws: Draws,
        @SerializedName("loses") val loses: Loses
    ) {
        data class Played(
            @SerializedName("home") val home: Int,
            @SerializedName("away") val away: Int,
            @SerializedName("total") val total: Int
        )

        data class Wins(
            @SerializedName("home") val home: Int,
            @SerializedName("away") val away: Int,
            @SerializedName("total") val total: Int
        )

        data class Draws(
            @SerializedName("home") val home: Int,
            @SerializedName("away") val away: Int,
            @SerializedName("total") val total: Int
        )

        data class Loses(
            @SerializedName("home") val home: Int,
            @SerializedName("away") val away: Int,
            @SerializedName("total") val total: Int
        )
    }

    data class Goals(
        @SerializedName("for") val goalsFor: GoalsFor,
        @SerializedName("against") val goalsAgainst: GoalsAgainst
    ) {
        data class GoalsFor(
            @SerializedName("total") val total: Total,
            @SerializedName("average") val average: Average,
            @SerializedName("minute") val minute: Minute
        ) {
            data class Total(
            @SerializedName("home")
            val home: Int?,

            @SerializedName("away")
            val away: Int?,

            @SerializedName("total")
            val total: Int
            )

            data class Average(
                @SerializedName("home") val home: String,
                @SerializedName("away") val away: String,
                @SerializedName("total") val total: String
            )

            data class Minute(
                @SerializedName("0-15") val zeroToFifteen: MinuteStats,
                @SerializedName("16-30") val sixteenToThirty: MinuteStats,
                @SerializedName("31-45") val thirtyOneToFortyFive: MinuteStats,
                @SerializedName("46-60") val fortySixToSixty: MinuteStats,
                @SerializedName("61-75") val sixtyOneToSeventyFive: MinuteStats,
                @SerializedName("76-90") val seventySixToNinety: MinuteStats,
                @SerializedName("91-105") val ninetyOneToOneHundredFive: MinuteStats?,
                @SerializedName("106-120") val oneHundredSixToOneHundredTwenty: MinuteStats?
            ) {
                data class MinuteStats(
                    @SerializedName("total") val total: Int?,
                    @SerializedName("percentage") val percentage: String?
                )
            }
        }

        data class GoalsAgainst(
            @SerializedName("total") val total: Total,
            @SerializedName("average") val average: Average,
            @SerializedName("minute") val minute: Minute
        ) {
            data class Total(
                @SerializedName("home") val home: Int?,
                @SerializedName("away") val away: Int?,
                @SerializedName("total") val total: Int
            )

            data class Average(
                @SerializedName("home") val home: String,
                @SerializedName("away") val away: String,
                @SerializedName("total") val total: String
            )

            data class Minute(
                @SerializedName("0-15") val zeroToFifteen: MinuteStats,
                @SerializedName("16-30") val sixteenToThirty: MinuteStats,
                @SerializedName("31-45") val thirtyOneToFortyFive: MinuteStats,
                @SerializedName("46-60") val fortySixToSixty: MinuteStats,
                @SerializedName("61-75") val sixtyOneToSeventyFive: MinuteStats,
                @SerializedName("76-90") val seventySixToNinety: MinuteStats,
                @SerializedName("91-105") val ninetyOneToOneHundredFive: MinuteStats?,
                @SerializedName("106-120") val oneHundredSixToOneHundredTwenty: MinuteStats?
            ) {
                data class MinuteStats(
                    @SerializedName("total") val total: Int?,
                    @SerializedName("percentage") val percentage: String?
                )
            }
        }
    }

    data class Biggest(
        @SerializedName("streak") val streak: Streak,
        @SerializedName("wins") val wins: WinsGoals,
        @SerializedName("loses") val loses: LosesGoals,
        @SerializedName("goals") val goals: GoalsForAgainst
    ) {
        data class Streak(
            @SerializedName("wins") val wins: Int,
            @SerializedName("draws") val draws: Int,
            @SerializedName("loses") val loses: Int
        )

        data class WinsGoals(
            @SerializedName("home") val home: String,
            @SerializedName("away") val away: String
        )

        data class LosesGoals(
            @SerializedName("home") val home: String,
            @SerializedName("away") val away: String
        )

        data class GoalsForAgainst(
            @SerializedName("for") val goalsFor: GoalsFor,
            @SerializedName("against") val goalsAgainst: GoalsAgainst
        ) {
            data class GoalsFor(
                @SerializedName("home") val home: Int,
                @SerializedName("away") val away: Int
            )

            data class GoalsAgainst(
                @SerializedName("home") val home: Int,
                @SerializedName("away") val away: Int
            )
        }
    }

    data class CleanSheet(
        @SerializedName("home") val home: Int,
        @SerializedName("away") val away: Int,
        @SerializedName("total") val total: Int
    )

    data class FailedToScore(
        @SerializedName("home")
        val away: Int,
        val total: Int
    )

    data class Penalty(
        @SerializedName("scored") val scored: Scored,
        @SerializedName("missed") val missed: Missed?,
        @SerializedName("total") val total: Int
    ) {
        data class Scored(
            @SerializedName("total") val total: Int,
            @SerializedName("percentage") val percentage: String
        )

        data class Missed(
            @SerializedName("total") val total: Int,
            @SerializedName("percentage") val percentage: String
        )
    }

    data class Lineup(
        @SerializedName("formation") val formation: String,
        @SerializedName("played") val played: Int
    )

    data class Cards(
        @SerializedName("yellow") val yellow: YellowCards,
        @SerializedName("red") val red: RedCards
    ) {
        data class YellowCards(
            @SerializedName("0-15") val zeroToFifteen: MinuteCards,
            @SerializedName("16-30") val sixteenToThirty: MinuteCards,
            @SerializedName("31-45") val thirtyOneToFortyFive: MinuteCards,
            @SerializedName("46-60") val fortySixToSixty: MinuteCards,
            @SerializedName("61-75") val sixtyOneToSeventyFive: MinuteCards,
            @SerializedName("76-90") val seventySixToNinety: MinuteCards,
            @SerializedName("91-105") val ninetyOneToOneHundredFive: MinuteCards?,
            @SerializedName("106-120") val oneHundredSixToOneHundredTwenty: MinuteCards?
        ) {
            data class MinuteCards(
                @SerializedName("total") val total: Int?,
                @SerializedName("percentage") val percentage: String?
            )
        }

        data class RedCards(
            @SerializedName("0-15") val zeroToFifteen: MinuteCards?,
            @SerializedName("16-30") val sixteenToThirty: MinuteCards?,
            @SerializedName("31-45") val thirtyOneToFortyFive: MinuteCards?,
            @SerializedName("46-60") val fortySixToSixty: MinuteCards?,
            @SerializedName("61-75") val sixtyOneToSeventyFive: MinuteCards?,
            @SerializedName("76-90") val seventySixToNinety: MinuteCards?,
            @SerializedName("91-105") val ninetyOneToOneHundredFive: MinuteCards?,
            @SerializedName("106-120") val oneHundredSixToOneHundredTwenty: MinuteCards?
        ) {
            data class MinuteCards(
                @SerializedName("total") val total: Int?,
                @SerializedName("percentage") val percentage: String?
            )
        }
    }
}