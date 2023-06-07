package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class GoalsForAgainstDTO(
    @SerializedName("for")
    val forX: Int,
    @SerializedName("against")
    val against: Int
)
