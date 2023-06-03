package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class PlayerPosGrid(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    val number: Int,
    @SerializedName("pos")
    val pos: String,
    @SerializedName("grid")
    val grid: Int?
)

