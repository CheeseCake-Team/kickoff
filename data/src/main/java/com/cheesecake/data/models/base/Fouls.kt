package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class Fouls(
    @SerializedName("drawn")
    val drawn: Int,
    @SerializedName("committed")
    val committed: Int
)