package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class VenueCityDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("city")
    val city: String
)
