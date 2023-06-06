package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class Matches(
    @SerializedName("home")
    val home: Int?,
    @SerializedName("away")
    val away: Int?
)
