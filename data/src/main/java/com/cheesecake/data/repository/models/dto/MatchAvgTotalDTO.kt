package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class MatchAvgTotalDTO(
    @SerializedName("average")
    val average: String,
    @SerializedName("total")
    val total: Int
)
