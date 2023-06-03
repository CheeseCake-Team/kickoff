package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class MatchAvgTotal(
    @SerializedName("average")
    val average: String,
    @SerializedName("total")
    val total: Int
)
