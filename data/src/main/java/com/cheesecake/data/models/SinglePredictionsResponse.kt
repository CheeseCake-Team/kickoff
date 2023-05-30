package com.cheesecake.data.models


import com.google.gson.annotations.SerializedName

data class SinglePredictionsResponse(
    @SerializedName("comparison")
    val comparison: Comparison,
    @SerializedName("h2h")
    val h2h: List<H2h>,
    @SerializedName("league")
    val league: League,
    @SerializedName("predictions")
    val predictions: Predictions,
    @SerializedName("teams")
    val teams: Teams
) {
    data class Comparison(
        @SerializedName("att")
        val att: Att,
        @SerializedName("def")
        val def: Def,
        @SerializedName("form")
        val form: Form,
        @SerializedName("goals")
        val goals: Goals,
        @SerializedName("h2h")
        val h2h: H2h,
        @SerializedName("poisson_distribution")
        val poissonDistribution: PoissonDistribution,
        @SerializedName("total")
        val total: Total
    ) {
        data class Att(
            @SerializedName("away")
            val away: String,
            @SerializedName("home")
            val home: String
        )

        data class Def(
            @SerializedName("away")
            val away: String,
            @SerializedName("home")
            val home: String
        )

        data class Form(
            @SerializedName("away")
            val away: String,
            @SerializedName("home")
            val home: String
        )

        data class Goals(
            @SerializedName("away")
            val away: String,
            @SerializedName("home")
            val home: String
        )

        data class H2h(
            @SerializedName("away")
            val away: String,
            @SerializedName("home")
            val home: String
        )

        data class PoissonDistribution(
            @SerializedName("away")
            val away: String,
            @SerializedName("home")
            val home: String
        )

        data class Total(
            @SerializedName("away")
            val away: String,
            @SerializedName("home")
            val home: String
        )
    }

    data class H2h(
        @SerializedName("fixture")
        val fixture: Fixture,
        @SerializedName("goals")
        val goals: Goals,
        @SerializedName("league")
        val league: League,
        @SerializedName("score")
        val score: Score,
        @SerializedName("teams")
        val teams: Teams
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

        data class Goals(
            @SerializedName("away")
            val away: Int,
            @SerializedName("home")
            val home: Int
        )

        data class League(
            @SerializedName("country")
            val country: String,
            @SerializedName("flag")
            val flag: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("logo")
            val logo: String,
            @SerializedName("name")
            val name: String,
            @SerializedName("round")
            val round: String,
            @SerializedName("season")
            val season: Int
        )

        data class Score(
            @SerializedName("extratime")
            val extratime: Extratime,
            @SerializedName("fulltime")
            val fulltime: Fulltime,
            @SerializedName("halftime")
            val halftime: Halftime,
            @SerializedName("penalty")
            val penalty: Penalty
        ) {
            data class Extratime(
                @SerializedName("away")
                val away: Any,
                @SerializedName("home")
                val home: Any
            )

            data class Fulltime(
                @SerializedName("away")
                val away: Int,
                @SerializedName("home")
                val home: Int
            )

            data class Halftime(
                @SerializedName("away")
                val away: Int,
                @SerializedName("home")
                val home: Int
            )

            data class Penalty(
                @SerializedName("away")
                val away: Any,
                @SerializedName("home")
                val home: Any
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
                @SerializedName("logo")
                val logo: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("winner")
                val winner: Boolean
            )

            data class Home(
                @SerializedName("id")
                val id: Int,
                @SerializedName("logo")
                val logo: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("winner")
                val winner: Boolean
            )
        }
    }

    data class League(
        @SerializedName("country")
        val country: String,
        @SerializedName("flag")
        val flag: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("logo")
        val logo: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("season")
        val season: Int
    )

    data class Predictions(
        @SerializedName("advice")
        val advice: String,
        @SerializedName("goals")
        val goals: Goals,
        @SerializedName("percent")
        val percent: Percent,
        @SerializedName("under_over")
        val underOver: String,
        @SerializedName("win_or_draw")
        val winOrDraw: Boolean,
        @SerializedName("winner")
        val winner: Winner
    ) {
        data class Goals(
            @SerializedName("away")
            val away: String,
            @SerializedName("home")
            val home: String
        )

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
                    val against: Against,
                    @SerializedName("for")
                    val forX: For
                ) {
                    data class Against(
                        @SerializedName("average")
                        val average: String,
                        @SerializedName("total")
                        val total: Int
                    )

                    data class For(
                        @SerializedName("average")
                        val average: String,
                        @SerializedName("total")
                        val total: Int
                    )
                }
            }

            data class League(
                @SerializedName("biggest")
                val biggest: Biggest,
                @SerializedName("cards")
                val cards: Cards,
                @SerializedName("clean_sheet")
                val cleanSheet: CleanSheet,
                @SerializedName("failed_to_score")
                val failedToScore: FailedToScore,
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
                    val loses: Loses,
                    @SerializedName("streak")
                    val streak: Streak,
                    @SerializedName("wins")
                    val wins: Wins
                ) {
                    data class Goals(
                        @SerializedName("against")
                        val against: Against,
                        @SerializedName("for")
                        val forX: For
                    ) {
                        data class Against(
                            @SerializedName("away")
                            val away: Int,
                            @SerializedName("home")
                            val home: Int
                        )

                        data class For(
                            @SerializedName("away")
                            val away: Int,
                            @SerializedName("home")
                            val home: Int
                        )
                    }

                    data class Loses(
                        @SerializedName("away")
                        val away: String,
                        @SerializedName("home")
                        val home: String
                    )

                    data class Streak(
                        @SerializedName("draws")
                        val draws: Int,
                        @SerializedName("loses")
                        val loses: Int,
                        @SerializedName("wins")
                        val wins: Int
                    )

                    data class Wins(
                        @SerializedName("away")
                        val away: String,
                        @SerializedName("home")
                        val home: String
                    )
                }

                data class Cards(
                    @SerializedName("red")
                    val red: Red,
                    @SerializedName("yellow")
                    val yellow: Yellow
                ) {
                    data class Red(
                        @SerializedName("0-15")
                        val x015: X015,
                        @SerializedName("106-120")
                        val x106120: X106120,
                        @SerializedName("16-30")
                        val x1630: X1630,
                        @SerializedName("31-45")
                        val x3145: X3145,
                        @SerializedName("46-60")
                        val x4660: X4660,
                        @SerializedName("61-75")
                        val x6175: X6175,
                        @SerializedName("76-90")
                        val x7690: X7690,
                        @SerializedName("91-105")
                        val x91105: X91105
                    ) {
                        data class X015(
                            @SerializedName("percentage")
                            val percentage: Any,
                            @SerializedName("total")
                            val total: Any
                        )

                        data class X106120(
                            @SerializedName("percentage")
                            val percentage: Any,
                            @SerializedName("total")
                            val total: Any
                        )

                        data class X1630(
                            @SerializedName("percentage")
                            val percentage: Any,
                            @SerializedName("total")
                            val total: Any
                        )

                        data class X3145(
                            @SerializedName("percentage")
                            val percentage: Any,
                            @SerializedName("total")
                            val total: Any
                        )

                        data class X4660(
                            @SerializedName("percentage")
                            val percentage: String,
                            @SerializedName("total")
                            val total: Int
                        )

                        data class X6175(
                            @SerializedName("percentage")
                            val percentage: String,
                            @SerializedName("total")
                            val total: Int
                        )

                        data class X7690(
                            @SerializedName("percentage")
                            val percentage: Any,
                            @SerializedName("total")
                            val total: Any
                        )

                        data class X91105(
                            @SerializedName("percentage")
                            val percentage: Any,
                            @SerializedName("total")
                            val total: Any
                        )
                    }

                    data class Yellow(
                        @SerializedName("0-15")
                        val x015: X015,
                        @SerializedName("106-120")
                        val x106120: X106120,
                        @SerializedName("16-30")
                        val x1630: X1630,
                        @SerializedName("31-45")
                        val x3145: X3145,
                        @SerializedName("46-60")
                        val x4660: X4660,
                        @SerializedName("61-75")
                        val x6175: X6175,
                        @SerializedName("76-90")
                        val x7690: X7690,
                        @SerializedName("91-105")
                        val x91105: X91105
                    ) {
                        data class X015(
                            @SerializedName("percentage")
                            val percentage: String,
                            @SerializedName("total")
                            val total: Int
                        )

                        data class X106120(
                            @SerializedName("percentage")
                            val percentage: Any,
                            @SerializedName("total")
                            val total: Any
                        )

                        data class X1630(
                            @SerializedName("percentage")
                            val percentage: String,
                            @SerializedName("total")
                            val total: Int
                        )

                        data class X3145(
                            @SerializedName("percentage")
                            val percentage: String,
                            @SerializedName("total")
                            val total: Int
                        )

                        data class X4660(
                            @SerializedName("percentage")
                            val percentage: String,
                            @SerializedName("total")
                            val total: Int
                        )

                        data class X6175(
                            @SerializedName("percentage")
                            val percentage: String,
                            @SerializedName("total")
                            val total: Int
                        )

                        data class X7690(
                            @SerializedName("percentage")
                            val percentage: String,
                            @SerializedName("total")
                            val total: Int
                        )

                        data class X91105(
                            @SerializedName("percentage")
                            val percentage: Any,
                            @SerializedName("total")
                            val total: Any
                        )
                    }
                }

                data class CleanSheet(
                    @SerializedName("away")
                    val away: Int,
                    @SerializedName("home")
                    val home: Int,
                    @SerializedName("total")
                    val total: Int
                )

                data class FailedToScore(
                    @SerializedName("away")
                    val away: Int,
                    @SerializedName("home")
                    val home: Int,
                    @SerializedName("total")
                    val total: Int
                )

                data class Fixtures(
                    @SerializedName("draws")
                    val draws: Draws,
                    @SerializedName("loses")
                    val loses: Loses,
                    @SerializedName("played")
                    val played: Played,
                    @SerializedName("wins")
                    val wins: Wins
                ) {
                    data class Draws(
                        @SerializedName("away")
                        val away: Int,
                        @SerializedName("home")
                        val home: Int,
                        @SerializedName("total")
                        val total: Int
                    )

                    data class Loses(
                        @SerializedName("away")
                        val away: Int,
                        @SerializedName("home")
                        val home: Int,
                        @SerializedName("total")
                        val total: Int
                    )

                    data class Played(
                        @SerializedName("away")
                        val away: Int,
                        @SerializedName("home")
                        val home: Int,
                        @SerializedName("total")
                        val total: Int
                    )

                    data class Wins(
                        @SerializedName("away")
                        val away: Int,
                        @SerializedName("home")
                        val home: Int,
                        @SerializedName("total")
                        val total: Int
                    )
                }

                data class Goals(
                    @SerializedName("against")
                    val against: Against,
                    @SerializedName("for")
                    val forX: For
                ) {
                    data class Against(
                        @SerializedName("average")
                        val average: Average,
                        @SerializedName("minute")
                        val minute: Minute,
                        @SerializedName("total")
                        val total: Total
                    ) {
                        data class Average(
                            @SerializedName("away")
                            val away: String,
                            @SerializedName("home")
                            val home: String,
                            @SerializedName("total")
                            val total: String
                        )

                        data class Minute(
                            @SerializedName("0-15")
                            val x015: X015,
                            @SerializedName("106-120")
                            val x106120: X106120,
                            @SerializedName("16-30")
                            val x1630: X1630,
                            @SerializedName("31-45")
                            val x3145: X3145,
                            @SerializedName("46-60")
                            val x4660: X4660,
                            @SerializedName("61-75")
                            val x6175: X6175,
                            @SerializedName("76-90")
                            val x7690: X7690,
                            @SerializedName("91-105")
                            val x91105: X91105
                        ) {
                            data class X015(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X106120(
                                @SerializedName("percentage")
                                val percentage: Any,
                                @SerializedName("total")
                                val total: Any
                            )

                            data class X1630(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X3145(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X4660(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X6175(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X7690(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X91105(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )
                        }

                        data class Total(
                            @SerializedName("away")
                            val away: Int,
                            @SerializedName("home")
                            val home: Int,
                            @SerializedName("total")
                            val total: Int
                        )
                    }

                    data class For(
                        @SerializedName("average")
                        val average: Average,
                        @SerializedName("minute")
                        val minute: Minute,
                        @SerializedName("total")
                        val total: Total
                    ) {
                        data class Average(
                            @SerializedName("away")
                            val away: String,
                            @SerializedName("home")
                            val home: String,
                            @SerializedName("total")
                            val total: String
                        )

                        data class Minute(
                            @SerializedName("0-15")
                            val x015: X015,
                            @SerializedName("106-120")
                            val x106120: X106120,
                            @SerializedName("16-30")
                            val x1630: X1630,
                            @SerializedName("31-45")
                            val x3145: X3145,
                            @SerializedName("46-60")
                            val x4660: X4660,
                            @SerializedName("61-75")
                            val x6175: X6175,
                            @SerializedName("76-90")
                            val x7690: X7690,
                            @SerializedName("91-105")
                            val x91105: X91105
                        ) {
                            data class X015(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X106120(
                                @SerializedName("percentage")
                                val percentage: Any,
                                @SerializedName("total")
                                val total: Any
                            )

                            data class X1630(
                                @SerializedName("percentage")
                                val percentage: Any,
                                @SerializedName("total")
                                val total: Any
                            )

                            data class X3145(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X4660(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X6175(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X7690(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X91105(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )
                        }

                        data class Total(
                            @SerializedName("away")
                            val away: Int,
                            @SerializedName("home")
                            val home: Int,
                            @SerializedName("total")
                            val total: Int
                        )
                    }
                }

                data class Penalty(
                    @SerializedName("missed")
                    val missed: Missed,
                    @SerializedName("scored")
                    val scored: Scored,
                    @SerializedName("total")
                    val total: Int
                ) {
                    data class Missed(
                        @SerializedName("percentage")
                        val percentage: String,
                        @SerializedName("total")
                        val total: Int
                    )

                    data class Scored(
                        @SerializedName("percentage")
                        val percentage: String,
                        @SerializedName("total")
                        val total: Int
                    )
                }
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
                    val against: Against,
                    @SerializedName("for")
                    val forX: For
                ) {
                    data class Against(
                        @SerializedName("average")
                        val average: String,
                        @SerializedName("total")
                        val total: Int
                    )

                    data class For(
                        @SerializedName("average")
                        val average: String,
                        @SerializedName("total")
                        val total: Int
                    )
                }
            }

            data class League(
                @SerializedName("biggest")
                val biggest: Biggest,
                @SerializedName("cards")
                val cards: Cards,
                @SerializedName("clean_sheet")
                val cleanSheet: CleanSheet,
                @SerializedName("failed_to_score")
                val failedToScore: FailedToScore,
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
                    val loses: Loses,
                    @SerializedName("streak")
                    val streak: Streak,
                    @SerializedName("wins")
                    val wins: Wins
                ) {
                    data class Goals(
                        @SerializedName("against")
                        val against: Against,
                        @SerializedName("for")
                        val forX: For
                    ) {
                        data class Against(
                            @SerializedName("away")
                            val away: Int,
                            @SerializedName("home")
                            val home: Int
                        )

                        data class For(
                            @SerializedName("away")
                            val away: Int,
                            @SerializedName("home")
                            val home: Int
                        )
                    }

                    data class Loses(
                        @SerializedName("away")
                        val away: String,
                        @SerializedName("home")
                        val home: String
                    )

                    data class Streak(
                        @SerializedName("draws")
                        val draws: Int,
                        @SerializedName("loses")
                        val loses: Int,
                        @SerializedName("wins")
                        val wins: Int
                    )

                    data class Wins(
                        @SerializedName("away")
                        val away: String,
                        @SerializedName("home")
                        val home: String
                    )
                }

                data class Cards(
                    @SerializedName("red")
                    val red: Red,
                    @SerializedName("yellow")
                    val yellow: Yellow
                ) {
                    data class Red(
                        @SerializedName("0-15")
                        val x015: X015,
                        @SerializedName("106-120")
                        val x106120: X106120,
                        @SerializedName("16-30")
                        val x1630: X1630,
                        @SerializedName("31-45")
                        val x3145: X3145,
                        @SerializedName("46-60")
                        val x4660: X4660,
                        @SerializedName("61-75")
                        val x6175: X6175,
                        @SerializedName("76-90")
                        val x7690: X7690,
                        @SerializedName("91-105")
                        val x91105: X91105
                    ) {
                        data class X015(
                            @SerializedName("percentage")
                            val percentage: Any,
                            @SerializedName("total")
                            val total: Any
                        )

                        data class X106120(
                            @SerializedName("percentage")
                            val percentage: Any,
                            @SerializedName("total")
                            val total: Any
                        )

                        data class X1630(
                            @SerializedName("percentage")
                            val percentage: Any,
                            @SerializedName("total")
                            val total: Any
                        )

                        data class X3145(
                            @SerializedName("percentage")
                            val percentage: Any,
                            @SerializedName("total")
                            val total: Any
                        )

                        data class X4660(
                            @SerializedName("percentage")
                            val percentage: Any,
                            @SerializedName("total")
                            val total: Any
                        )

                        data class X6175(
                            @SerializedName("percentage")
                            val percentage: Any,
                            @SerializedName("total")
                            val total: Any
                        )

                        data class X7690(
                            @SerializedName("percentage")
                            val percentage: Any,
                            @SerializedName("total")
                            val total: Any
                        )

                        data class X91105(
                            @SerializedName("percentage")
                            val percentage: Any,
                            @SerializedName("total")
                            val total: Any
                        )
                    }

                    data class Yellow(
                        @SerializedName("0-15")
                        val x015: X015,
                        @SerializedName("106-120")
                        val x106120: X106120,
                        @SerializedName("16-30")
                        val x1630: X1630,
                        @SerializedName("31-45")
                        val x3145: X3145,
                        @SerializedName("46-60")
                        val x4660: X4660,
                        @SerializedName("61-75")
                        val x6175: X6175,
                        @SerializedName("76-90")
                        val x7690: X7690,
                        @SerializedName("91-105")
                        val x91105: X91105
                    ) {
                        data class X015(
                            @SerializedName("percentage")
                            val percentage: String,
                            @SerializedName("total")
                            val total: Int
                        )

                        data class X106120(
                            @SerializedName("percentage")
                            val percentage: Any,
                            @SerializedName("total")
                            val total: Any
                        )

                        data class X1630(
                            @SerializedName("percentage")
                            val percentage: String,
                            @SerializedName("total")
                            val total: Int
                        )

                        data class X3145(
                            @SerializedName("percentage")
                            val percentage: String,
                            @SerializedName("total")
                            val total: Int
                        )

                        data class X4660(
                            @SerializedName("percentage")
                            val percentage: String,
                            @SerializedName("total")
                            val total: Int
                        )

                        data class X6175(
                            @SerializedName("percentage")
                            val percentage: String,
                            @SerializedName("total")
                            val total: Int
                        )

                        data class X7690(
                            @SerializedName("percentage")
                            val percentage: String,
                            @SerializedName("total")
                            val total: Int
                        )

                        data class X91105(
                            @SerializedName("percentage")
                            val percentage: Any,
                            @SerializedName("total")
                            val total: Any
                        )
                    }
                }

                data class CleanSheet(
                    @SerializedName("away")
                    val away: Int,
                    @SerializedName("home")
                    val home: Int,
                    @SerializedName("total")
                    val total: Int
                )

                data class FailedToScore(
                    @SerializedName("away")
                    val away: Int,
                    @SerializedName("home")
                    val home: Int,
                    @SerializedName("total")
                    val total: Int
                )

                data class Fixtures(
                    @SerializedName("draws")
                    val draws: Draws,
                    @SerializedName("loses")
                    val loses: Loses,
                    @SerializedName("played")
                    val played: Played,
                    @SerializedName("wins")
                    val wins: Wins
                ) {
                    data class Draws(
                        @SerializedName("away")
                        val away: Int,
                        @SerializedName("home")
                        val home: Int,
                        @SerializedName("total")
                        val total: Int
                    )

                    data class Loses(
                        @SerializedName("away")
                        val away: Int,
                        @SerializedName("home")
                        val home: Int,
                        @SerializedName("total")
                        val total: Int
                    )

                    data class Played(
                        @SerializedName("away")
                        val away: Int,
                        @SerializedName("home")
                        val home: Int,
                        @SerializedName("total")
                        val total: Int
                    )

                    data class Wins(
                        @SerializedName("away")
                        val away: Int,
                        @SerializedName("home")
                        val home: Int,
                        @SerializedName("total")
                        val total: Int
                    )
                }

                data class Goals(
                    @SerializedName("against")
                    val against: Against,
                    @SerializedName("for")
                    val forX: For
                ) {
                    data class Against(
                        @SerializedName("average")
                        val average: Average,
                        @SerializedName("minute")
                        val minute: Minute,
                        @SerializedName("total")
                        val total: Total
                    ) {
                        data class Average(
                            @SerializedName("away")
                            val away: String,
                            @SerializedName("home")
                            val home: String,
                            @SerializedName("total")
                            val total: String
                        )

                        data class Minute(
                            @SerializedName("0-15")
                            val x015: X015,
                            @SerializedName("106-120")
                            val x106120: X106120,
                            @SerializedName("16-30")
                            val x1630: X1630,
                            @SerializedName("31-45")
                            val x3145: X3145,
                            @SerializedName("46-60")
                            val x4660: X4660,
                            @SerializedName("61-75")
                            val x6175: X6175,
                            @SerializedName("76-90")
                            val x7690: X7690,
                            @SerializedName("91-105")
                            val x91105: X91105
                        ) {
                            data class X015(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X106120(
                                @SerializedName("percentage")
                                val percentage: Any,
                                @SerializedName("total")
                                val total: Any
                            )

                            data class X1630(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X3145(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X4660(
                                @SerializedName("percentage")
                                val percentage: Any,
                                @SerializedName("total")
                                val total: Any
                            )

                            data class X6175(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X7690(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X91105(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )
                        }

                        data class Total(
                            @SerializedName("away")
                            val away: Int,
                            @SerializedName("home")
                            val home: Int,
                            @SerializedName("total")
                            val total: Int
                        )
                    }

                    data class For(
                        @SerializedName("average")
                        val average: Average,
                        @SerializedName("minute")
                        val minute: Minute,
                        @SerializedName("total")
                        val total: Total
                    ) {
                        data class Average(
                            @SerializedName("away")
                            val away: String,
                            @SerializedName("home")
                            val home: String,
                            @SerializedName("total")
                            val total: String
                        )

                        data class Minute(
                            @SerializedName("0-15")
                            val x015: X015,
                            @SerializedName("106-120")
                            val x106120: X106120,
                            @SerializedName("16-30")
                            val x1630: X1630,
                            @SerializedName("31-45")
                            val x3145: X3145,
                            @SerializedName("46-60")
                            val x4660: X4660,
                            @SerializedName("61-75")
                            val x6175: X6175,
                            @SerializedName("76-90")
                            val x7690: X7690,
                            @SerializedName("91-105")
                            val x91105: X91105
                        ) {
                            data class X015(
                                @SerializedName("percentage")
                                val percentage: Any,
                                @SerializedName("total")
                                val total: Any
                            )

                            data class X106120(
                                @SerializedName("percentage")
                                val percentage: Any,
                                @SerializedName("total")
                                val total: Any
                            )

                            data class X1630(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X3145(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X4660(
                                @SerializedName("percentage")
                                val percentage: Any,
                                @SerializedName("total")
                                val total: Any
                            )

                            data class X6175(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X7690(
                                @SerializedName("percentage")
                                val percentage: String,
                                @SerializedName("total")
                                val total: Int
                            )

                            data class X91105(
                                @SerializedName("percentage")
                                val percentage: Any,
                                @SerializedName("total")
                                val total: Any
                            )
                        }

                        data class Total(
                            @SerializedName("away")
                            val away: Int,
                            @SerializedName("home")
                            val home: Int,
                            @SerializedName("total")
                            val total: Int
                        )
                    }
                }

                data class Penalty(
                    @SerializedName("missed")
                    val missed: Missed,
                    @SerializedName("scored")
                    val scored: Scored,
                    @SerializedName("total")
                    val total: Int
                ) {
                    data class Missed(
                        @SerializedName("percentage")
                        val percentage: String,
                        @SerializedName("total")
                        val total: Int
                    )

                    data class Scored(
                        @SerializedName("percentage")
                        val percentage: String,
                        @SerializedName("total")
                        val total: Int
                    )
                }
            }
        }
    }
}