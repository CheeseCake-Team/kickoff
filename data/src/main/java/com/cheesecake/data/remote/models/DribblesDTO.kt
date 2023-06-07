package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class DribblesDTO(
    @SerializedName("attempts")
    val attempts: Int,
    @SerializedName("success")
    val success: Int,
    @SerializedName("past")
    val past: Int
)
