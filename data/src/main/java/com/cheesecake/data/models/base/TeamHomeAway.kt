package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class TeamHomeAway(
    @SerializedName("home")
    val home: HomeAway,
    @SerializedName("away")
    val away: HomeAway
)
