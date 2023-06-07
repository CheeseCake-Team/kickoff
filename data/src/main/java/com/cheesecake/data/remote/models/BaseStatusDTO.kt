package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class BaseStatusDTO(
    @SerializedName("long")
    val long: String,
    @SerializedName("short")
    val short: String,
    @SerializedName("elapsed")
    val elapsed: Int
)
