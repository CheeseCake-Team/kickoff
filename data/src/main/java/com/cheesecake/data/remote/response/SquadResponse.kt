package com.cheesecake.data.remote.response


import com.cheesecake.data.remote.models.TeamDTO
import com.google.gson.annotations.SerializedName

data class SquadResponse(
    @SerializedName("team")
    val team: com.cheesecake.data.remote.models.TeamDTO,
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