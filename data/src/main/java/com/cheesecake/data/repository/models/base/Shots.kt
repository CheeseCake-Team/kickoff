package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class Shots(
    @SerializedName("total")
    val total: Int,
    @SerializedName("on")
    val on: Int
)
