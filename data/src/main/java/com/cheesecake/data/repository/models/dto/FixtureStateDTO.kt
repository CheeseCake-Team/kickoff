package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class FixtureStateDTO(
    @SerializedName("draws")
    val draws: MatchesTotalDTO,
    @SerializedName("loses")
    val loses: MatchesTotalDTO,
    @SerializedName("played")
    val played: MatchesTotalDTO,
    @SerializedName("wins")
    val wins: MatchesTotalDTO
)
