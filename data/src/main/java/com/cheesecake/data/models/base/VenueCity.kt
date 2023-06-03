package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class VenueCity(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("city")
    val city: String
)
