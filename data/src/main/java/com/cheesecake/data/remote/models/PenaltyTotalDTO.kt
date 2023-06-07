package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class PenaltyTotalDTO(
    @SerializedName("missed")
    val missed: com.cheesecake.data.remote.models.PercentageTotalDTO,
    @SerializedName("scored")
    val scored: com.cheesecake.data.remote.models.PercentageTotalDTO,
    @SerializedName("total")
    val total: Int
)