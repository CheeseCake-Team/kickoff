package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class MatchesDTO(
    @SerializedName("home")
    val home: Int?,
    @SerializedName("away")
    val away: Int?
)
