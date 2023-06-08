package com.cheesecake.data.remote.response


import com.google.gson.annotations.SerializedName

data class TeamResponse(
    @SerializedName("team")
    val team: TeamDto,
    @SerializedName("venue")
    val venue: Venue
) {
    data class TeamDto(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("code")
        val code: String,
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
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("address")
        val address: String,
        @SerializedName("city")
        val city: String,
        @SerializedName("capacity")
        val capacity: Int,
        @SerializedName("surface")
        val surface: String,
        @SerializedName("image")
        val image: String
    )
}


