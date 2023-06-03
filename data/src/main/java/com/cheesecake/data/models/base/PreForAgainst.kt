package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class PreForAgainst(
    @SerializedName("average")
    val average: MatchesTotal,
    @SerializedName("minute")
    val minute: Minute0105,
    @SerializedName("total")
    val total: MatchesTotal
)
