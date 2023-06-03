package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class ScoreBlock(
    @SerializedName("halftime")
    val halftime: Matches,
    @SerializedName("fulltime")
    val fulltime: Matches,
    @SerializedName("extratime")
    val extratime: Matches,
    @SerializedName("penalty")
    val penalty: Matches
)
