package com.cheesecake.data.repository.models.dto

import com.cheesecake.data.repository.models.base.PersonPhoto
import com.cheesecake.data.repository.models.base.PlayerPosGrid
import com.cheesecake.data.repository.models.base.TeamColor
import com.google.gson.annotations.SerializedName

data class LineupDTO(
    @SerializedName("team")
    val team: Team,
    @SerializedName("coach")
    val coach: com.cheesecake.data.repository.models.base.PersonPhoto,
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
        val colors: com.cheesecake.data.repository.models.base.TeamColor
    )

    data class StartXI(
        @SerializedName("player")
        val player: com.cheesecake.data.repository.models.base.PlayerPosGrid
    )

    data class Substitute(
        @SerializedName("player")
        val player: com.cheesecake.data.repository.models.base.PlayerPosGrid
    )
}