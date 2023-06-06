package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class TimezoneDTO(
    @SerializedName("response")
    val timezones: List<String>
)