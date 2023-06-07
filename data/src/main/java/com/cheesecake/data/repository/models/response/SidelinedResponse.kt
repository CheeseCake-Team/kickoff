package com.cheesecake.data.repository.models.response


import com.google.gson.annotations.SerializedName

data class SidelinedResponse(
    @SerializedName("end")
    val end: String,
    @SerializedName("start")
    val start: String,
    @SerializedName("type")
    val type: String
)