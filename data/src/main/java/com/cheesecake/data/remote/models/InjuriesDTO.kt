package com.cheesecake.data.remote.models


import com.cheesecake.data.remote.models.*
import com.google.gson.annotations.SerializedName

data class InjuriesDTO(
    @SerializedName("player")
    val player: Player,
    @SerializedName("team")
    val team: TeamDataDTO,
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