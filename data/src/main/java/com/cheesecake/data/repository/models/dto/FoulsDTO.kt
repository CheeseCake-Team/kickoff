package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class FoulsDTO(
    @SerializedName("drawn")
    val drawn: Int,
    @SerializedName("committed")
    val committed: Int
)