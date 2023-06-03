package com.cheesecake.data.models.dto


import com.google.gson.annotations.SerializedName

data class SidelinedDTO(
    @SerializedName("end")
    val end: String,
    @SerializedName("start")
    val start: String,
    @SerializedName("type")
    val type: String
)