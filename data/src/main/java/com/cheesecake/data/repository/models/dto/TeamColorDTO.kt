package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class TeamColorDTO(
    @SerializedName("player")
    val player: PlayerColorDTO,
    @SerializedName("goalkeeper")
    val goalkeeper: PlayerColorDTO
)
