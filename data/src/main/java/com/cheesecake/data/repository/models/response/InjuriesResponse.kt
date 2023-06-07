package com.cheesecake.data.repository.models.response


import com.cheesecake.data.repository.models.dto.LeagueCountrySeasonDTO
import com.cheesecake.data.repository.models.dto.TeamDTO
import com.google.gson.annotations.SerializedName

data class InjuriesResponse(
    @SerializedName("player")
    val player: Player,
    @SerializedName("team")
    val team: TeamDTO,
    @SerializedName("fixture")
    val fixture: Fixture,
    @SerializedName("league")
    val league: LeagueCountrySeasonDTO
) {
    data class Player(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("photo")
        val photo: String,
        @SerializedName("type")
        val type: String,
        @SerializedName("reason")
        val reason: String
    )

    data class Fixture(
        @SerializedName("id")
        val id: Int,
        @SerializedName("timezone")
        val timezone: String,
        @SerializedName("date")
        val date: String,
        @SerializedName("timestamp")
        val timestamp: Int
    )
}