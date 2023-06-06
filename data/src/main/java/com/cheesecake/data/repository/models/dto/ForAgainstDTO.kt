package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class ForAgainstDTO(
    @SerializedName("total") val total: MatchesTotalDTO,
    @SerializedName("average") val average: MatchesTotalDTO,
    @SerializedName("minute") val minute: BaseCardsDTO
)
