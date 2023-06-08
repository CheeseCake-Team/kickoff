package com.cheesecake.data.remote.response


import com.google.gson.annotations.SerializedName

data class FixtureResponse(
    @SerializedName("fixture")
    val fixtureDTO: com.cheesecake.data.remote.models.FixtureDTO,
    @SerializedName("league")
    val league: com.cheesecake.data.remote.models.LeagueCountrySeasonRoundDTO,
    @SerializedName("teams")
    val teams: com.cheesecake.data.remote.models.TeamHomeAwayDTO,
    @SerializedName("goals")
    val goals: com.cheesecake.data.remote.models.MatchesDTO,
    @SerializedName("score")
    val score: com.cheesecake.data.remote.models.ScoreBlockDTO
)
