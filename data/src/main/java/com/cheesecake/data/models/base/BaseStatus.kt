package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class BaseStatus(
    @SerializedName("long")
    val long: String,
    @SerializedName("short")
    val short: String,
    @SerializedName("elapsed")
    val elapsed: Int
)
