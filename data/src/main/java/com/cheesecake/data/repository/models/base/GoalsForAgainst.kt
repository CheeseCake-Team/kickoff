package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class GoalsForAgainst(
    @SerializedName("for")
    val forX: Int,
    @SerializedName("against")
    val against: Int
)
