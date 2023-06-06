package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class PenaltyTotal(
    @SerializedName("missed")
    val missed: com.cheesecake.data.repository.models.base.PercentageTotal,
    @SerializedName("scored")
    val scored: com.cheesecake.data.repository.models.base.PercentageTotal,
    @SerializedName("total")
    val total: Int
)