package com.cheesecake.data.remote.response


import com.cheesecake.data.remote.models.LeagueCountrySeasonDTO
import com.cheesecake.data.remote.models.TeamDTO
import com.google.gson.annotations.SerializedName

data class InjuriesResponse(
    @SerializedName("player")
    val player: com.cheesecake.data.remote.response.InjuriesResponse.Player,
    @SerializedName("team")
    val team: com.cheesecake.data.remote.models.TeamDTO,
    @SerializedName("fixture")
    val fixture: com.cheesecake.data.remote.response.InjuriesResponse.Fixture,
    @SerializedName("league")
    val league: com.cheesecake.data.remote.models.LeagueCountrySeasonDTO
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