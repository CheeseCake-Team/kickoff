package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class ForAgainst(
    @SerializedName("total") val total: Matches,
    @SerializedName("average") val average: Matches,
    @SerializedName("minute") val minute: BaseCards
)
