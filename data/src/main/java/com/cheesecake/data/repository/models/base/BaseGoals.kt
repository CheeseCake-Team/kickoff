package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

class BaseGoals(
    @SerializedName("home") val home: String,
    @SerializedName("away") val away: String
)
