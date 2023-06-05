package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class HomeAway(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("winner")
    val winner: Boolean
)
