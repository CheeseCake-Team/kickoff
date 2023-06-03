package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class Dribbles(
    @SerializedName("attempts")
    val attempts: Int,
    @SerializedName("success")
    val success: Int,
    @SerializedName("past")
    val past: Int
)
