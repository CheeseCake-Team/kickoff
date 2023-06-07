package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class FoulsDTO(
    @SerializedName("drawn")
    val drawn: Int,
    @SerializedName("committed")
    val committed: Int
)