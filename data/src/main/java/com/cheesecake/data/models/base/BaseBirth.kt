package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class BaseBirth(
    @SerializedName("date")
    val date: String,
    @SerializedName("place")
    val place: String,
    @SerializedName("country")
    val country: String
)
