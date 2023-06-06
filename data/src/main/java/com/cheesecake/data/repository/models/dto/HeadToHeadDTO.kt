package com.cheesecake.data.repository.models.dto

import com.cheesecake.data.repository.models.base.Fixture
import com.cheesecake.data.repository.models.base.LeagueCountrySeasonRound
import com.cheesecake.data.repository.models.base.Matches
import com.cheesecake.data.repository.models.base.ScoreBlock
import com.cheesecake.data.repository.models.base.TeamHomeAway
import com.google.gson.annotations.SerializedName

data class HeadToHeadDTO(
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
) {

}