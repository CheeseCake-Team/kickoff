package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class TeamLargeDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("last_5")
    val last5: com.cheesecake.data.remote.models.TeamLargeDTO.Last5,
    @SerializedName("league")
    val league: com.cheesecake.data.remote.models.TeamLargeDTO.League,
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
        val goals: com.cheesecake.data.remote.models.TeamLargeDTO.Last5.Goals
    ) {
        data class Goals(
            @SerializedName("against")
            val against: com.cheesecake.data.remote.models.MatchAvgTotalDTO,
            @SerializedName("for")
            val forX: com.cheesecake.data.remote.models.MatchAvgTotalDTO
        )
    }

    data class League(
        @SerializedName("biggest")
        val biggest: com.cheesecake.data.remote.models.TeamLargeDTO.League.Biggest,
        @SerializedName("cards")
        val cards: com.cheesecake.data.remote.models.Cards0105DTO,
        @SerializedName("clean_sheet")
        val cleanSheet: com.cheesecake.data.remote.models.MatchesTotalDTO,
        @SerializedName("failed_to_score")
        val failedToScore: com.cheesecake.data.remote.models.MatchesTotalDTO,
        @SerializedName("fixtures")
        val fixtures: com.cheesecake.data.remote.models.FixtureStateDTO,
        @SerializedName("form")
        val form: String,
        @SerializedName("goals")
        val goals: com.cheesecake.data.remote.models.TeamLargeDTO.League.Goals,
        @SerializedName("lineups")
        val lineups: List<String?>,
        @SerializedName("penalty")
        val penalty: com.cheesecake.data.remote.models.PenaltyTotalDTO
    ) {
        data class Biggest(
            @SerializedName("goals")
            val goals: com.cheesecake.data.remote.models.TeamLargeDTO.League.Biggest.Goals,
            @SerializedName("loses")
            val loses: com.cheesecake.data.remote.models.MatchesDTO,
            @SerializedName("streak")
            val streak: com.cheesecake.data.remote.models.TeamLargeDTO.League.Biggest.Streak,
            @SerializedName("wins")
            val wins: com.cheesecake.data.remote.models.MatchesDTO
        ) {
            data class Goals(
                @SerializedName("against")
                val against: com.cheesecake.data.remote.models.MatchesDTO,
                @SerializedName("for")
                val forX: com.cheesecake.data.remote.models.MatchesDTO
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
            val against: com.cheesecake.data.remote.models.PreForAgainstDTO,
            @SerializedName("for")
            val forX: com.cheesecake.data.remote.models.PreForAgainstDTO
        )
    }
}
