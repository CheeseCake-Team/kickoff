package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class PreForAgainstDTO(
    @SerializedName("average")
    val average: MatchesTotalDTO,
    @SerializedName("minute")
    val minute: Minute0105DTO,
    @SerializedName("total")
    val total: MatchesTotalDTO
)
