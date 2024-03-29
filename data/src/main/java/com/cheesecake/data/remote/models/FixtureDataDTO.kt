package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName
import java.util.Date

data class FixtureDataDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("referee")
    val referee: String,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("date")
    val date: Date,
    @SerializedName("timestamp")
    val timestamp: Int,
    @SerializedName("periods")
    val periods: BasePeriodsDTO,
    @SerializedName("venue")
    val venue: VenueCityDTO,
    @SerializedName("status")
    val status: BaseStatusDTO
)
