package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class DuelsDTO(
    @SerializedName("total")
    val total: Int,
    @SerializedName("won")
    val won: Int
)