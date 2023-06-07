package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class PercentageTotalDTO(
    @SerializedName("percentage")
    val percentage: String,
    @SerializedName("total")
    val total: Int?
)