package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class PlayerPosGridDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    val number: Int,
    @SerializedName("pos")
    val pos: String,
    @SerializedName("grid")
    val grid: String?
)

