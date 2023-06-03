package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class PercentageTotal(
    @SerializedName("percentage")
    val percentage: String,
    @SerializedName("total")
    val total: Int?
)