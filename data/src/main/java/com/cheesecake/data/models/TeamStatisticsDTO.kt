package com.cheesecake.data.models

import com.cheesecake.data.models.base.BaseCards
import com.cheesecake.data.models.base.BaseGoals
import com.cheesecake.data.models.base.BasePenalty
import com.cheesecake.data.models.base.ForAgainst
import com.cheesecake.data.models.base.Matches
import com.cheesecake.data.models.base.Team
import com.google.gson.annotations.SerializedName

data class TeamStatisticsDTO(
    @SerializedName("league") val league: League,
    @SerializedName("team") val team: Team,
    @SerializedName("form") val form: String,
    @SerializedName("fixtures") val fixtures: Fixtures,
    @SerializedName("goals") val goals: Goals,
    @SerializedName("biggest") val biggest: Biggest,
    @SerializedName("clean_sheet") val cleanSheet: Matches,
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

    data class Fixtures(
        @SerializedName("played") val played: Matches,
        @SerializedName("wins") val wins: Matches,
        @SerializedName("draws") val draws: Matches,
        @SerializedName("loses") val loses: Matches
    )

    data class Goals(
        @SerializedName("for") val goalsFor: ForAgainst,
        @SerializedName("against") val goalsAgainst: ForAgainst
    )

    data class Biggest(
        @SerializedName("streak") val streak: Streak,
        @SerializedName("wins") val wins: BaseGoals,
        @SerializedName("loses") val loses: BaseGoals,
        @SerializedName("goals") val goals: GoalsForAgainst
    ) {
        data class Streak(
            @SerializedName("wins") val wins: Int,
            @SerializedName("draws") val draws: Int,
            @SerializedName("loses") val loses: Int
        )

        data class GoalsForAgainst(
            @SerializedName("for") val goalsFor: Goals,
            @SerializedName("against") val goalsAgainst: Goals
        )
    }

    data class FailedToScore(
        @SerializedName("home") val away: Int,
        val total: Int
    )

    data class Penalty(
        @SerializedName("scored") val scored: BasePenalty,
        @SerializedName("missed") val missed: BasePenalty?,
        @SerializedName("total") val total: Int
    )

    data class Lineup(
        @SerializedName("formation") val formation: String,
        @SerializedName("played") val played: Int
    )

    data class Cards(
        @SerializedName("yellow") val yellow: BaseCards,
        @SerializedName("red") val red: BaseCards
    )
}