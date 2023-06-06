package com.cheesecake.data.repository.models.dto


import com.cheesecake.data.repository.models.base.Team
import com.google.gson.annotations.SerializedName

data class SquadDTO(
    @SerializedName("team")
    val team: com.cheesecake.data.repository.models.base.Team,
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