package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class FixtureStateDTO(
    @SerializedName("draws")
    val draws: com.cheesecake.data.remote.models.MatchesTotalDTO,
    @SerializedName("loses")
    val loses: com.cheesecake.data.remote.models.MatchesTotalDTO,
    @SerializedName("played")
    val played: com.cheesecake.data.remote.models.MatchesTotalDTO,
    @SerializedName("wins")
    val wins: com.cheesecake.data.remote.models.MatchesTotalDTO
)
