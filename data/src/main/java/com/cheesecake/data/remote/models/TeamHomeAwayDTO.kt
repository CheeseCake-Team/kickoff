package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class TeamHomeAwayDTO(
    @SerializedName("home")
    val home: com.cheesecake.data.remote.models.HomeAwayDTO,
    @SerializedName("away")
    val away: com.cheesecake.data.remote.models.HomeAwayDTO
)
