package com.cheesecake.data.repository.models.response


import com.cheesecake.data.local.models.TeamLocalDto
import com.cheesecake.domain.entity.TeamEntity
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

fun TeamInformationResponse.mapToDomain(): TeamEntity {
    return TeamEntity(
        teamId = this.team.id,
        teamName = this.team.name,
        founded = this.team.founded,
        teamCountry = this.team.country,
        venueCapacity = this.venue.capacity,
        venueName = this.venue.name,
        imageUrl = this.team.logo,
        isFavourite = false
    )
}

fun List<TeamInformationResponse>.mapToDomain():List<TeamEntity>{
    return this.map { it.mapToDomain() }
}

fun TeamEntity.toLocal(leagueId: Int, leagueSeason: Int): TeamLocalDto {
    return TeamLocalDto(
        teamId = this.teamId,
        leagueId = leagueId,
        season = leagueSeason,
        teamName = this.teamName,
        founded = this.founded,
        teamCountry = this.teamCountry,
        venueCapacity = this.venueCapacity,
        venueName = this.venueName,
        imageUrl = this.imageUrl,
        isFavourite = this.isFavourite
    )
}

