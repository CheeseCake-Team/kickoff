package com.cheesecake.data.models


import com.google.gson.annotations.SerializedName

data class SingleSidelinedResponse(
    @SerializedName("end")
    val end: String,
    @SerializedName("start")
    val start: String,
    @SerializedName("type")
    val type: String
)