package com.cheesecake.data.repository.models.dto

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
    val periods: BasePeriodsDTO,
    @SerializedName("venue")
    val venue: VenueCityDTO,
    @SerializedName("status")
    val status: BaseStatusDTO
)
