package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class BasePeriodsDTO(
    @SerializedName("first")
    val first: Int,
    @SerializedName("second")
    val second: Int
)
