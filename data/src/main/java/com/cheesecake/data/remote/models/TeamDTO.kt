package com.cheesecake.data.remote.models


import com.google.gson.annotations.SerializedName

data class TeamDTO(
    @SerializedName("team")
    val team: TeamDataDto,
    @SerializedName("venue")
    val venue: Venue
) {
    data class TeamDataDto(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("code")
        val code: String?,
        @SerializedName("country")
        val country: String,
        @SerializedName("founded")
        val founded: Int,
        @SerializedName("national")
        val national: Boolean,
        @SerializedName("logo")
        val logo: String
    )

    data class Venue(
        @SerializedName("id")
        val id: Int?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("address")
        val address: String?,
        @SerializedName("city")
        val city: String?,
        @SerializedName("capacity")
        val capacity: Int?,
        @SerializedName("surface")
        val surface: String?,
        @SerializedName("image")
        val image: String?
    )
}


