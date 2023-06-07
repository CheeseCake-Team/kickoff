package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class ForAgainstDTO(
    @SerializedName("total") val total: com.cheesecake.data.remote.models.MatchesTotalDTO,
    @SerializedName("average") val average: com.cheesecake.data.remote.models.MatchesTotalDTO,
    @SerializedName("minute") val minute: com.cheesecake.data.remote.models.BaseCardsDTO
)
