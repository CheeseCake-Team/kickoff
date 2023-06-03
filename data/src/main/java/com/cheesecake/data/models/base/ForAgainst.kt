package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class ForAgainst(
    @SerializedName("total") val total: MatchesTotal,
    @SerializedName("average") val average: MatchesTotal,
    @SerializedName("minute") val minute: BaseCards
)
