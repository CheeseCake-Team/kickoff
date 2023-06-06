package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class TeamHomeAway(
    @SerializedName("home")
    val home: com.cheesecake.data.repository.models.base.HomeAway,
    @SerializedName("away")
    val away: com.cheesecake.data.repository.models.base.HomeAway
)
