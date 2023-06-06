package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class ForAgainst(
    @SerializedName("total") val total: com.cheesecake.data.repository.models.base.MatchesTotal,
    @SerializedName("average") val average: com.cheesecake.data.repository.models.base.MatchesTotal,
    @SerializedName("minute") val minute: com.cheesecake.data.repository.models.base.BaseCards
)
