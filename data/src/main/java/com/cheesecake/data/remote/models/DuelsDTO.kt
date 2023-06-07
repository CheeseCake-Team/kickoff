package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class DuelsDTO(
    @SerializedName("total")
    val total: Int,
    @SerializedName("won")
    val won: Int
)