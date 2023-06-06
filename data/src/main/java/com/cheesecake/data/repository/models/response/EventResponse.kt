package com.cheesecake.data.repository.models.response


import com.cheesecake.data.repository.models.dto.PlayerMetaDTO
import com.cheesecake.data.repository.models.dto.TeamDTO
import com.cheesecake.data.repository.models.dto.TimeMetaDTO
import com.google.gson.annotations.SerializedName

data class EventResponse(
    @SerializedName("time")
    val time: TimeMetaDTO,
    @SerializedName("team")
    val team: TeamDTO,
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