package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

class BaseGoalsDTO(
    @SerializedName("home") val home: String,
    @SerializedName("away") val away: String
)
