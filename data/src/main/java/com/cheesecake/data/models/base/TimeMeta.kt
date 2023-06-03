package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class TimeMeta(
    @SerializedName("elapsed")
    val elapsed: Int?,
    @SerializedName("extra")
    val extra: Int?
)
