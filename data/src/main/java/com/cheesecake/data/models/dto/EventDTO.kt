package com.cheesecake.data.models.dto


import com.cheesecake.data.models.base.PlayerMeta
import com.cheesecake.data.models.base.Team
import com.cheesecake.data.models.base.TimeMeta
import com.google.gson.annotations.SerializedName

data class EventDTO(
    @SerializedName("time")
    val time: TimeMeta,
    @SerializedName("team")
    val team: Team,
    @SerializedName("player")
    val player: PlayerMeta,
    @SerializedName("assist")
    val assist: PlayerMeta,
    @SerializedName("type")
    val type: String,
    @SerializedName("detail")
    val detail: String,
    @SerializedName("comments")
    val comments: String
)