package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

class BaseGoalsDTO(
    @SerializedName("home") val home: String,
    @SerializedName("away") val away: String
)
