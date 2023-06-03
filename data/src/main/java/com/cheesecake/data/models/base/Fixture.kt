package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class Fixture(
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
    val periods: BasePeriods,
    @SerializedName("venue")
    val venue: VenueCity,
    @SerializedName("status")
    val status: BaseStatus
)
