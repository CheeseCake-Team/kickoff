package com.cheesecake.data.models.dto

import com.google.gson.annotations.SerializedName

data class TimezoneDTO(
    @SerializedName("response")
    val timezones: List<String>
)