package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class PenaltyTotal(
    @SerializedName("missed")
    val missed: PercentageTotal,
    @SerializedName("scored")
    val scored: PercentageTotal,
    @SerializedName("total")
    val total: Int
)