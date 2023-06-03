package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class TeamLarge(
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
        val cards: Cards0105,
        @SerializedName("clean_sheet")
        val cleanSheet: MatchesTotal,
        @SerializedName("failed_to_score")
        val failedToScore: MatchesTotal,
        @SerializedName("fixtures")
        val fixtures: FixtureState,
        @SerializedName("form")
        val form: String,
        @SerializedName("goals")
        val goals: Goals,
        @SerializedName("lineups")
        val lineups: List<String?>,
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

        data class Goals(
            @SerializedName("against")
            val against: PreForAgainst,
            @SerializedName("for")
            val forX: PreForAgainst
        )
    }
}
