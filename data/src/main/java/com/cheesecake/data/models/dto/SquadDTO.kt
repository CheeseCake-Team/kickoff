package com.cheesecake.data.models.dto


import com.cheesecake.data.models.base.Team
import com.google.gson.annotations.SerializedName

data class SquadDTO(
    @SerializedName("team")
    val team: Team,
    @SerializedName("players")
    val players: List<Player>
) {
    data class Player(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("age")
        val age: Int,
        @SerializedName("number")
        val number: Int,
        @SerializedName("position")
        val position: String,
        @SerializedName("photo")
        val photo: String
    )
}