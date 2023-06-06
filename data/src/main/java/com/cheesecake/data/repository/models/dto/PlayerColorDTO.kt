package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class PlayerColorDTO(
    @SerializedName("primary")
    val primary: String,
    @SerializedName("number")
    val number: String,
    @SerializedName("border")
    val border: String
)
