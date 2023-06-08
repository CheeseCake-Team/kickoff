package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class TacklesDTO(
    @SerializedName("total")
    val total: Int,
    @SerializedName("blocks")
    val blocks: Int,
    @SerializedName("interceptions")
    val interceptions: Int
)