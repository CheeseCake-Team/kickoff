package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class ShotsDTO(
    @SerializedName("total")
    val total: Int,
    @SerializedName("on")
    val on: Int
)
