package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class BasePenaltyDTO(
    @SerializedName("total") val total: Int,
    @SerializedName("percentage") val percentage: String
)
