package com.cheesecake.data.models


import com.cheesecake.data.models.base.LeagueCountrySeason
import com.cheesecake.data.models.base.Team
import com.google.gson.annotations.SerializedName

data class IjuriesDTO(
    @SerializedName("player")
    val player: Player,
    @SerializedName("team")
    val team: Team,
    @SerializedName("fixture")
    val fixture: Fixture,
    @SerializedName("league")
    val league: LeagueCountrySeason
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