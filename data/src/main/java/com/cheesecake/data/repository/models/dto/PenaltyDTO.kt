package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class PenaltyDTO(
    @SerializedName("won")
    val won: Any,
    @SerializedName("commited")
    val commited: Any,
    @SerializedName("scored")
    val scored: Int,
    @SerializedName("missed")
    val missed: Int,
    @SerializedName("saved")
    val saved: Int
)
