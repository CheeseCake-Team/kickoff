package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class TimeMetaDTO(
    @SerializedName("elapsed")
    val elapsed: Int?,
    @SerializedName("extra")
    val extra: Int?
)
