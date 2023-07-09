package com.cheesecake.data.remote.models


import com.google.gson.annotations.SerializedName

data class SidelinedDTO(
    @SerializedName("end")
    val end: String,
    @SerializedName("start")
    val start: String,
    @SerializedName("type")
    val type: String
)