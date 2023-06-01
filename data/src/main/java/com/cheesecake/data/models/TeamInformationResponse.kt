package com.cheesecake.data.models


import androidx.room.PrimaryKey
import com.cheesecake.data.local.models.LocalTeam
import com.google.gson.annotations.SerializedName

data class TeamInformationResponse(
    @SerializedName("team")
    val team: Team,
    @SerializedName("venue")
    val venue: Venue
) {
    data class Team(
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

fun TeamInformationResponse.toLocal() = LocalTeam(
    teamId = this.team.id,
    teamName = this.team.name,
    founded = this.team.founded,
    teamCountry = this.team.country,
    venueCapacity = this.venue.capacity,
    venueName = this.venue.name,
    imageUrl = this.team.logo
)