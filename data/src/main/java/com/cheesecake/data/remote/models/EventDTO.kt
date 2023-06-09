package com.cheesecake.data.remote.models

import com.cheesecake.data.remote.models.*
import com.google.gson.annotations.SerializedName

data class EventDTO(
    @SerializedName("time")
    val time: TimeMetaDTO,
    @SerializedName("team")
    val team: TeamDataDTO,
    @SerializedName("player")
    val player: PlayerMetaDTO,
    @SerializedName("assist")
    val assist: PlayerMetaDTO,
    @SerializedName("type")
    val type: String,
    @SerializedName("detail")
    val detail: String,
    @SerializedName("comments")
    val comments: String
)