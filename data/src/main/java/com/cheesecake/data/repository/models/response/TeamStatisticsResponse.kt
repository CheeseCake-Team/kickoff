package com.cheesecake.data.repository.models.response

import com.cheesecake.data.repository.models.dto.BaseCardsDTO
import com.cheesecake.data.repository.models.dto.BaseGoalsDTO
import com.cheesecake.data.repository.models.dto.BasePenaltyDTO
import com.cheesecake.data.repository.models.dto.ForAgainstDTO
import com.cheesecake.data.repository.models.dto.MatchesTotalDTO
import com.cheesecake.data.repository.models.dto.TeamDTO
import com.google.gson.annotations.SerializedName

data class TeamStatisticsResponse(
    @SerializedName("league") val league: League,
    @SerializedName("team") val team: TeamDTO,
    @SerializedName("form") val form: String,
    @SerializedName("fixtures") val fixtures: Fixtures,
    @SerializedName("goals") val goals: Goals,
    @SerializedName("biggest") val biggest: Biggest,
    @SerializedName("clean_sheet") val cleanSheet: MatchesTotalDTO,
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
        @SerializedName("played") val played: MatchesTotalDTO,
        @SerializedName("wins") val wins: MatchesTotalDTO,
        @SerializedName("draws") val draws: MatchesTotalDTO,
        @SerializedName("loses") val loses: MatchesTotalDTO
    )

    data class Goals(
        @SerializedName("for") val goalsFor: ForAgainstDTO,
        @SerializedName("against") val goalsAgainst: ForAgainstDTO
    )

    data class Biggest(
        @SerializedName("streak") val streak: Streak,
        @SerializedName("wins") val wins: BaseGoalsDTO,
        @SerializedName("loses") val loses: BaseGoalsDTO,
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
        @SerializedName("scored") val scored: BasePenaltyDTO,
        @SerializedName("missed") val missed: BasePenaltyDTO?,
        @SerializedName("total") val total: Int
    )

    data class Lineup(
        @SerializedName("formation") val formation: String,
        @SerializedName("played") val played: Int
    )

    data class Cards(
        @SerializedName("yellow") val yellow: BaseCardsDTO,
        @SerializedName("red") val red: BaseCardsDTO
    )
}