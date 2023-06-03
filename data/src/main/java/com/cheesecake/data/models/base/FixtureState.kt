package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class FixtureState(
    @SerializedName("draws")
    val draws: MatchesTotal,
    @SerializedName("loses")
    val loses: MatchesTotal,
    @SerializedName("played")
    val played: MatchesTotal,
    @SerializedName("wins")
    val wins: MatchesTotal
)
