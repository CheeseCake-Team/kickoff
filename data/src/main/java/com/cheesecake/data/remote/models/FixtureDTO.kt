package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class FixtureDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("referee")
    val referee: String,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("timestamp")
    val timestamp: Int,
    @SerializedName("periods")
    val periods: com.cheesecake.data.remote.models.BasePeriodsDTO,
    @SerializedName("venue")
    val venue: com.cheesecake.data.remote.models.VenueCityDTO,
    @SerializedName("status")
    val status: com.cheesecake.data.remote.models.BaseStatusDTO
)
