package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class TimeMetaDTO(
    @SerializedName("elapsed")
    val elapsed: Int?,
    @SerializedName("extra")
    val extra: Int?
)
