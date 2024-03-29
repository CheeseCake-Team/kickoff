package com.cheesecake.data.remote.models

import com.cheesecake.data.remote.models.*
import com.google.gson.annotations.SerializedName

data class LineupDTO(
    @SerializedName("team")
    val team: Team,
    @SerializedName("coach")
    val coach: PersonPhotoDTO,
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
        val colors: TeamColorDTO
    )

    data class StartXI(
        @SerializedName("player")
        val player: PlayerPosGridDTO
    )

    data class Substitute(
        @SerializedName("player")
        val player: PlayerPosGridDTO
    )
}