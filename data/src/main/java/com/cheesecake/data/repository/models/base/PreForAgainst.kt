package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class PreForAgainst(
    @SerializedName("average")
    val average: com.cheesecake.data.repository.models.base.MatchesTotal,
    @SerializedName("minute")
    val minute: com.cheesecake.data.repository.models.base.Minute0105,
    @SerializedName("total")
    val total: com.cheesecake.data.repository.models.base.MatchesTotal
)
