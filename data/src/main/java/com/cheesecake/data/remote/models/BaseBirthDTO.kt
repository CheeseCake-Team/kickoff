package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class BaseBirthDTO(
    @SerializedName("date")
    val date: String,
    @SerializedName("place")
    val place: String?,
    @SerializedName("country")
    val country: String
)
