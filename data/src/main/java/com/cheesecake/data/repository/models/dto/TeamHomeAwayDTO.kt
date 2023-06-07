package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class TeamHomeAwayDTO(
    @SerializedName("home")
    val home: HomeAwayDTO,
    @SerializedName("away")
    val away: HomeAwayDTO
)
