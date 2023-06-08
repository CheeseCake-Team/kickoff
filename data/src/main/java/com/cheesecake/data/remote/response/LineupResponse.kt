package com.cheesecake.data.remote.response

import com.cheesecake.data.remote.models.PersonPhotoDTO
import com.cheesecake.data.remote.models.PlayerPosGridDTO
import com.cheesecake.data.remote.models.TeamColorDTO
import com.google.gson.annotations.SerializedName

data class LineupResponse(
    @SerializedName("team")
    val team: Team,
    @SerializedName("coach")
    val coach: com.cheesecake.data.remote.models.PersonPhotoDTO,
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
        val colors: com.cheesecake.data.remote.models.TeamColorDTO
    )

    data class StartXI(
        @SerializedName("player")
        val player: com.cheesecake.data.remote.models.PlayerPosGridDTO
    )

    data class Substitute(
        @SerializedName("player")
        val player: com.cheesecake.data.remote.models.PlayerPosGridDTO
    )
}