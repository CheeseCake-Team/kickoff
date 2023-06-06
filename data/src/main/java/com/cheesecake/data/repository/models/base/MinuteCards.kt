package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class MinuteCards(
    @SerializedName("total") val total: Int?,
    @SerializedName("percentage") val percentage: String?
)
