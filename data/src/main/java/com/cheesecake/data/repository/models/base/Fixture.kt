package com.cheesecake.data.repository.models.base

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
    val periods: com.cheesecake.data.repository.models.base.BasePeriods,
    @SerializedName("venue")
    val venue: com.cheesecake.data.repository.models.base.VenueCity,
    @SerializedName("status")
    val status: com.cheesecake.data.repository.models.base.BaseStatus
)
