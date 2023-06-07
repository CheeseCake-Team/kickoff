package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class ScoreBlockDTO(
    @SerializedName("halftime")
    val halftime: MatchesDTO,
    @SerializedName("fulltime")
    val fulltime: MatchesDTO,
    @SerializedName("extratime")
    val extratime: MatchesDTO,
    @SerializedName("penalty")
    val penalty: MatchesDTO
)
