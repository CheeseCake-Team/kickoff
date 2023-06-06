package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class TeamColor(
    @SerializedName("player")
    val player: com.cheesecake.data.repository.models.base.PlayerColor,
    @SerializedName("goalkeeper")
    val goalkeeper: com.cheesecake.data.repository.models.base.PlayerColor
)
