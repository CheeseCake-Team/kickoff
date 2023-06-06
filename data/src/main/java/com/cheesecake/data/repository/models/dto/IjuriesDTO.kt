package com.cheesecake.data.repository.models.dto


import com.cheesecake.data.repository.models.base.LeagueCountrySeason
import com.cheesecake.data.repository.models.base.Team
import com.google.gson.annotations.SerializedName

data class IjuriesDTO(
    @SerializedName("player")
    val player: com.cheesecake.data.repository.models.dto.IjuriesDTO.Player,
    @SerializedName("team")
    val team: com.cheesecake.data.repository.models.base.Team,
    @SerializedName("fixture")
    val fixture: com.cheesecake.data.repository.models.dto.IjuriesDTO.Fixture,
    @SerializedName("league")
    val league: com.cheesecake.data.repository.models.base.LeagueCountrySeason
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