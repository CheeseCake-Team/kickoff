package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class FixtureState(
    @SerializedName("draws")
    val draws: com.cheesecake.data.repository.models.base.MatchesTotal,
    @SerializedName("loses")
    val loses: com.cheesecake.data.repository.models.base.MatchesTotal,
    @SerializedName("played")
    val played: com.cheesecake.data.repository.models.base.MatchesTotal,
    @SerializedName("wins")
    val wins: com.cheesecake.data.repository.models.base.MatchesTotal
)
