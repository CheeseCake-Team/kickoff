package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

class BaseGoals(
    @SerializedName("home") val home: String,
    @SerializedName("away") val away: String
)
