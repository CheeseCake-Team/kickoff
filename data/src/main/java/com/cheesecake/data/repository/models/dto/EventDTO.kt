package com.cheesecake.data.repository.models.dto


import com.cheesecake.data.repository.models.base.PlayerMeta
import com.cheesecake.data.repository.models.base.Team
import com.cheesecake.data.repository.models.base.TimeMeta
import com.google.gson.annotations.SerializedName

data class EventDTO(
    @SerializedName("time")
    val time: com.cheesecake.data.repository.models.base.TimeMeta,
    @SerializedName("team")
    val team: com.cheesecake.data.repository.models.base.Team,
    @SerializedName("player")
    val player: com.cheesecake.data.repository.models.base.PlayerMeta,
    @SerializedName("assist")
    val assist: com.cheesecake.data.repository.models.base.PlayerMeta,
    @SerializedName("type")
    val type: String,
    @SerializedName("detail")
    val detail: String,
    @SerializedName("comments")
    val comments: String
)