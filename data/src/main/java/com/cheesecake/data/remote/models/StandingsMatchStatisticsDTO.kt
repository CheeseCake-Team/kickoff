package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class StandingsMatchStatisticsDTO(
    @SerializedName("played")
    val played: Int,
    @SerializedName("win")
    val win: Int,
    @SerializedName("draw")
    val draw: Int,
    @SerializedName("lose")
    val lose: Int,
    @SerializedName("goals")
    val goals: com.cheesecake.data.remote.models.GoalsForAgainstDTO
)
