package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class ScoreBlockDTO(
    @SerializedName("halftime")
    val halftime: com.cheesecake.data.remote.models.MatchesDTO,
    @SerializedName("fulltime")
    val fulltime: com.cheesecake.data.remote.models.MatchesDTO,
    @SerializedName("extratime")
    val extratime: com.cheesecake.data.remote.models.MatchesDTO,
    @SerializedName("penalty")
    val penalty: com.cheesecake.data.remote.models.MatchesDTO
)
