package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class Duels(
    @SerializedName("total")
    val total: Int,
    @SerializedName("won")
    val won: Int
)