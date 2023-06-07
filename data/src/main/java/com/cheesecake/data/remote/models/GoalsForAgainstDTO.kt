package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class GoalsForAgainstDTO(
    @SerializedName("for")
    val forX: Int,
    @SerializedName("against")
    val against: Int
)
