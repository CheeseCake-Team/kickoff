package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class PercentageTotalDTO(
    @SerializedName("percentage")
    val percentage: String,
    @SerializedName("total")
    val total: Int?
)