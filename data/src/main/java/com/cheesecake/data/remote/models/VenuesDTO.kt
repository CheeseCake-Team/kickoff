package com.cheesecake.data.remote.models


import com.google.gson.annotations.SerializedName

data class VenuesDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("capacity")
    val capacity: Int,
    @SerializedName("surface")
    val surface: String,
    @SerializedName("image")
    val image: String
)