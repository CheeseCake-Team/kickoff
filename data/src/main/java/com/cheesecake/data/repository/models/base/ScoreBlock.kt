package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class ScoreBlock(
    @SerializedName("halftime")
    val halftime: com.cheesecake.data.repository.models.base.Matches,
    @SerializedName("fulltime")
    val fulltime: com.cheesecake.data.repository.models.base.Matches,
    @SerializedName("extratime")
    val extratime: com.cheesecake.data.repository.models.base.Matches,
    @SerializedName("penalty")
    val penalty: com.cheesecake.data.repository.models.base.Matches
)
