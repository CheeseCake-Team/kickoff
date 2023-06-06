package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class TeamLarge(
    @SerializedName("id")
    val id: Int,
    @SerializedName("last_5")
    val last5: com.cheesecake.data.repository.models.base.TeamLarge.Last5,
    @SerializedName("league")
    val league: com.cheesecake.data.repository.models.base.TeamLarge.League,
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
        val goals: com.cheesecake.data.repository.models.base.TeamLarge.Last5.Goals
    ) {
        data class Goals(
            @SerializedName("against")
            val against: com.cheesecake.data.repository.models.base.MatchAvgTotal,
            @SerializedName("for")
            val forX: com.cheesecake.data.repository.models.base.MatchAvgTotal
        )
    }

    data class League(
        @SerializedName("biggest")
        val biggest: com.cheesecake.data.repository.models.base.TeamLarge.League.Biggest,
        @SerializedName("cards")
        val cards: com.cheesecake.data.repository.models.base.Cards0105,
        @SerializedName("clean_sheet")
        val cleanSheet: com.cheesecake.data.repository.models.base.MatchesTotal,
        @SerializedName("failed_to_score")
        val failedToScore: com.cheesecake.data.repository.models.base.MatchesTotal,
        @SerializedName("fixtures")
        val fixtures: com.cheesecake.data.repository.models.base.FixtureState,
        @SerializedName("form")
        val form: String,
        @SerializedName("goals")
        val goals: com.cheesecake.data.repository.models.base.TeamLarge.League.Goals,
        @SerializedName("lineups")
        val lineups: List<String?>,
        @SerializedName("penalty")
        val penalty: com.cheesecake.data.repository.models.base.PenaltyTotal
    ) {
        data class Biggest(
            @SerializedName("goals")
            val goals: com.cheesecake.data.repository.models.base.TeamLarge.League.Biggest.Goals,
            @SerializedName("loses")
            val loses: com.cheesecake.data.repository.models.base.Matches,
            @SerializedName("streak")
            val streak: com.cheesecake.data.repository.models.base.TeamLarge.League.Biggest.Streak,
            @SerializedName("wins")
            val wins: com.cheesecake.data.repository.models.base.Matches
        ) {
            data class Goals(
                @SerializedName("against")
                val against: com.cheesecake.data.repository.models.base.Matches,
                @SerializedName("for")
                val forX: com.cheesecake.data.repository.models.base.Matches
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
            val against: com.cheesecake.data.repository.models.base.PreForAgainst,
            @SerializedName("for")
            val forX: com.cheesecake.data.repository.models.base.PreForAgainst
        )
    }
}
