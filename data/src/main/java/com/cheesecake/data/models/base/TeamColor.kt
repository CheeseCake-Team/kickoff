package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class TeamColor(
    @SerializedName("player")
    val player: PlayerColor,
    @SerializedName("goalkeeper")
    val goalkeeper: PlayerColor
)
