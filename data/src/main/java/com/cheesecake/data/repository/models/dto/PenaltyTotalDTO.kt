package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class PenaltyTotalDTO(
    @SerializedName("missed")
    val missed: PercentageTotalDTO,
    @SerializedName("scored")
    val scored: PercentageTotalDTO,
    @SerializedName("total")
    val total: Int
)