package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class BasePenaltyDTO(
    @SerializedName("total") val total: Int,
    @SerializedName("percentage") val percentage: String
)
