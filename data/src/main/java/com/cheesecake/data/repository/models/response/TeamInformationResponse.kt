package com.cheesecake.data.repository.models.response


import com.cheesecake.domain.Entity.TeamInformation
import com.google.gson.annotations.SerializedName

data class TeamInformationResponse(
    @SerializedName("team")
    val team: TeamInformation,
    @SerializedName("venue")
    val venue: Venue
) {
    data class TeamInformation(
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

fun TeamInformationResponse.mapToDomain(): TeamInformation {
    return TeamInformation(
        //TODO implement TeamInformation data class
    )
}

fun List<TeamInformationResponse>.mapToDomain():List<TeamInformation>{
    return this.map { it.mapToDomain() }
}

