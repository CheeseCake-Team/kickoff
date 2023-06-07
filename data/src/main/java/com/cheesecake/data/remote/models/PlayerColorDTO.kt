package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class PlayerColorDTO(
    @SerializedName("primary")
    val primary: String,
    @SerializedName("number")
    val number: String,
    @SerializedName("border")
    val border: String
)
