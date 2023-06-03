package com.cheesecake.data.models.dto

import com.cheesecake.data.models.base.PersonPhoto
import com.cheesecake.data.models.base.PlayerPosGrid
import com.cheesecake.data.models.base.TeamColor
import com.google.gson.annotations.SerializedName

data class LineupDTO(
    @SerializedName("team")
    val team: Team,
    @SerializedName("coach")
    val coach: PersonPhoto,
    @SerializedName("formation")
    val formation: String,
    @SerializedName("startXI")
    val startXI: List<StartXI>,
    @SerializedName("substitutes")
    val substitutes: List<Substitute>
) {
    data class Team(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("logo")
        val logo: String,
        @SerializedName("colors")
        val colors: TeamColor
    )

    data class StartXI(
        @SerializedName("player")
        val player: PlayerPosGrid
    )

    data class Substitute(
        @SerializedName("player")
        val player: PlayerPosGrid
    )
}