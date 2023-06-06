package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class Tackles(
    @SerializedName("total")
    val total: Int,
    @SerializedName("blocks")
    val blocks: Int,
    @SerializedName("interceptions")
    val interceptions: Int
)