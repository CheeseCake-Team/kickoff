package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class StandingsMatchStatistics(
    @SerializedName("played")
    val played: Int,
    @SerializedName("win")
    val win: Int,
    @SerializedName("draw")
    val draw: Int,
    @SerializedName("lose")
    val lose: Int,
    @SerializedName("goals")
    val goals: GoalsForAgainst
)
