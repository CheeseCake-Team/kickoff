package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class TimeMeta(
    @SerializedName("elapsed")
    val elapsed: Int?,
    @SerializedName("extra")
    val extra: Int?
)
