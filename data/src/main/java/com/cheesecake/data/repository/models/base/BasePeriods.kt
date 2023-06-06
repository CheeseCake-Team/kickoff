package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class BasePeriods(
    @SerializedName("first")
    val first: Int,
    @SerializedName("second")
    val second: Int
)
