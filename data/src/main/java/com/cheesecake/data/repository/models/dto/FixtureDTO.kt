package com.cheesecake.data.repository.models.dto


import com.google.gson.annotations.SerializedName

data class FixtureDTO(
    @SerializedName("fixture")
    val fixture: com.cheesecake.data.repository.models.base.Fixture,
    @SerializedName("league")
    val league: com.cheesecake.data.repository.models.base.LeagueCountrySeasonRound,
    @SerializedName("teams")
    val teams: com.cheesecake.data.repository.models.base.TeamHomeAway,
    @SerializedName("goals")
    val goals: com.cheesecake.data.repository.models.base.Matches,
    @SerializedName("score")
    val score: com.cheesecake.data.repository.models.base.ScoreBlock
)