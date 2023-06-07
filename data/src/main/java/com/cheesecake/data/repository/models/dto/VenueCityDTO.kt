package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class VenueCityDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("city")
    val city: String
)
