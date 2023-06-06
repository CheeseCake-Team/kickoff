package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class PlayerColor(
    @SerializedName("primary")
    val primary: String,
    @SerializedName("number")
    val number: String,
    @SerializedName("border")
    val border: String
)
