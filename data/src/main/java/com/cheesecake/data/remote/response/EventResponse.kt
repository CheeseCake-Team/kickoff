package com.cheesecake.data.remote.response


import com.cheesecake.data.remote.models.PlayerMetaDTO
import com.cheesecake.data.remote.models.TeamDTO
import com.cheesecake.data.remote.models.TimeMetaDTO
import com.google.gson.annotations.SerializedName

data class EventResponse(
    @SerializedName("time")
    val time: com.cheesecake.data.remote.models.TimeMetaDTO,
    @SerializedName("team")
    val team: com.cheesecake.data.remote.models.TeamDTO,
    @SerializedName("player")
    val player: com.cheesecake.data.remote.models.PlayerMetaDTO,
    @SerializedName("assist")
    val assist: com.cheesecake.data.remote.models.PlayerMetaDTO,
    @SerializedName("type")
    val type: String,
    @SerializedName("detail")
    val detail: String,
    @SerializedName("comments")
    val comments: String
)