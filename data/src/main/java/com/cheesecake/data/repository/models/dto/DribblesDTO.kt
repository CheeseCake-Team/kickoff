package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class DribblesDTO(
    @SerializedName("attempts")
    val attempts: Int,
    @SerializedName("success")
    val success: Int,
    @SerializedName("past")
    val past: Int
)
