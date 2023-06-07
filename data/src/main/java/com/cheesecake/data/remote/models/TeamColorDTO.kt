package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class TeamColorDTO(
    @SerializedName("player")
    val player: com.cheesecake.data.remote.models.PlayerColorDTO,
    @SerializedName("goalkeeper")
    val goalkeeper: com.cheesecake.data.remote.models.PlayerColorDTO
)
