package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class BasePenalty(
    @SerializedName("total") val total: Int,
    @SerializedName("percentage") val percentage: String
)
