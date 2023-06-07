package com.cheesecake.data.remote.response

import com.cheesecake.data.remote.models.BaseCardsDTO
import com.cheesecake.data.remote.models.BaseGoalsDTO
import com.cheesecake.data.remote.models.BasePenaltyDTO
import com.cheesecake.data.remote.models.ForAgainstDTO
import com.cheesecake.data.remote.models.MatchesTotalDTO
import com.cheesecake.data.remote.models.TeamDTO
import com.google.gson.annotations.SerializedName

data class TeamStatisticsResponse(
    @SerializedName("league") val league: League,
    @SerializedName("team") val team: com.cheesecake.data.remote.models.TeamDTO,
    @SerializedName("form") val form: String,
    @SerializedName("fixtures") val fixtures: Fixtures,
    @SerializedName("goals") val goals: Goals,
    @SerializedName("biggest") val biggest: Biggest,
    @SerializedName("clean_sheet") val cleanSheet: com.cheesecake.data.remote.models.MatchesTotalDTO,
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
        @SerializedName("played") val played: com.cheesecake.data.remote.models.MatchesTotalDTO,
        @SerializedName("wins") val wins: com.cheesecake.data.remote.models.MatchesTotalDTO,
        @SerializedName("draws") val draws: com.cheesecake.data.remote.models.MatchesTotalDTO,
        @SerializedName("loses") val loses: com.cheesecake.data.remote.models.MatchesTotalDTO
    )

    data class Goals(
        @SerializedName("for") val goalsFor: com.cheesecake.data.remote.models.ForAgainstDTO,
        @SerializedName("against") val goalsAgainst: com.cheesecake.data.remote.models.ForAgainstDTO
    )

    data class Biggest(
        @SerializedName("streak") val streak: Streak,
        @SerializedName("wins") val wins: com.cheesecake.data.remote.models.BaseGoalsDTO,
        @SerializedName("loses") val loses: com.cheesecake.data.remote.models.BaseGoalsDTO,
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
        @SerializedName("scored") val scored: com.cheesecake.data.remote.models.BasePenaltyDTO,
        @SerializedName("missed") val missed: com.cheesecake.data.remote.models.BasePenaltyDTO?,
        @SerializedName("total") val total: Int
    )

    data class Lineup(
        @SerializedName("formation") val formation: String,
        @SerializedName("played") val played: Int
    )

    data class Cards(
        @SerializedName("yellow") val yellow: com.cheesecake.data.remote.models.BaseCardsDTO,
        @SerializedName("red") val red: com.cheesecake.data.remote.models.BaseCardsDTO
    )
}