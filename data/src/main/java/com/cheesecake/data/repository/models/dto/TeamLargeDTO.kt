package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class TeamLargeDTO(
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
            val against: MatchAvgTotalDTO,
            @SerializedName("for")
            val forX: MatchAvgTotalDTO
        )
    }

    data class League(
        @SerializedName("biggest")
        val biggest: League.Biggest,
        @SerializedName("cards")
        val cards: Cards0105DTO,
        @SerializedName("clean_sheet")
        val cleanSheet: MatchesTotalDTO,
        @SerializedName("failed_to_score")
        val failedToScore: MatchesTotalDTO,
        @SerializedName("fixtures")
        val fixtures: FixtureStateDTO,
        @SerializedName("form")
        val form: String,
        @SerializedName("goals")
        val goals: League.Goals,
        @SerializedName("lineups")
        val lineups: List<String?>,
        @SerializedName("penalty")
        val penalty: PenaltyTotalDTO
    ) {
        data class Biggest(
            @SerializedName("goals")
            val goals: Goals,
            @SerializedName("loses")
            val loses: MatchesDTO,
            @SerializedName("streak")
            val streak: Streak,
            @SerializedName("wins")
            val wins: MatchesDTO
        ) {
            data class Goals(
                @SerializedName("against")
                val against: MatchesDTO,
                @SerializedName("for")
                val forX: MatchesDTO
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
            val against: PreForAgainstDTO,
            @SerializedName("for")
            val forX: PreForAgainstDTO
        )
    }
}
