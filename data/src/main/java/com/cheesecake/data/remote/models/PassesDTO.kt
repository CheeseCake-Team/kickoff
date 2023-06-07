package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class PassesDTO(
    @SerializedName("total")
    val total: Int,
    @SerializedName("key")
    val key: Int,
    @SerializedName("accuracy")
    val accuracy: Int
)
