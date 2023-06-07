package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class TacklesDTO(
    @SerializedName("total")
    val total: Int,
    @SerializedName("blocks")
    val blocks: Int,
    @SerializedName("interceptions")
    val interceptions: Int
)