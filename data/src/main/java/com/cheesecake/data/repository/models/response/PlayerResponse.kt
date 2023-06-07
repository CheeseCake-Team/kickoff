package com.cheesecake.data.repository.models.response

import com.cheesecake.domain.entity.PlayerEntity
import com.google.gson.annotations.SerializedName

data class PlayerResponse(
    @SerializedName("player")
    val player: Player,
    @SerializedName("statistics")
    val statistics: List<Statistic>
) {
    data class Player(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("firstname")
        val firstname: String,
        @SerializedName("lastname")
        val lastname: String,
        @SerializedName("age")
        val age: Int,
        @SerializedName("birth")
        val birth: com.cheesecake.data.repository.models.dto.BaseBirthDTO,
        @SerializedName("nationality")
        val nationality: String,
        @SerializedName("height")
        val height: String,
        @SerializedName("weight")
        val weight: String,
        @SerializedName("injured")
        val injured: Boolean,
        @SerializedName("photo")
        val photo: String
    )

    data class Statistic(
        @SerializedName("team")
        val team: com.cheesecake.data.repository.models.dto.TeamDTO,
        @SerializedName("league")
        val league: com.cheesecake.data.repository.models.dto.LeagueCountrySeasonDTO,
        @SerializedName("games")
        val games: Games,
        @SerializedName("substitutes")
        val substitutes: Substitutes,
        @SerializedName("shots")
        val shots: com.cheesecake.data.repository.models.dto.ShotsDTO,
        @SerializedName("goals")
        val goals: com.cheesecake.data.repository.models.dto.GoalsStateDTO,
        @SerializedName("passes")
        val passes: com.cheesecake.data.repository.models.dto.PassesDTO,
        @SerializedName("tackles")
        val tackles: com.cheesecake.data.repository.models.dto.TacklesDTO,
        @SerializedName("duels")
        val duels: com.cheesecake.data.repository.models.dto.DuelsDTO,
        @SerializedName("dribbles")
        val dribbles: com.cheesecake.data.repository.models.dto.DribblesDTO,
        @SerializedName("fouls")
        val fouls: com.cheesecake.data.repository.models.dto.FoulsDTO,
        @SerializedName("cards")
        val cards: com.cheesecake.data.repository.models.dto.CardsDTO,
        @SerializedName("penalty")
        val penalty: com.cheesecake.data.repository.models.dto.PenaltyDTO
    ) {

        data class Games(
            @SerializedName("appearences")
            val appearences: Int,
            @SerializedName("lineups")
            val lineups: Int,
            @SerializedName("minutes")
            val minutes: Int,
            @SerializedName("number")
            val number: Any,
            @SerializedName("position")
            val position: String,
            @SerializedName("rating")
            val rating: String,
            @SerializedName("captain")
            val captain: Boolean
        )

        data class Substitutes(
            @SerializedName("in")
            val inX: Int,
            @SerializedName("out")
            val `out`: Int,
            @SerializedName("bench")
            val bench: Int
        )
    }
}


fun PlayerResponse.mapToDomain(): PlayerEntity{
    return PlayerEntity(

    )
}

fun List<PlayerResponse>.mapToDomain():List<PlayerEntity>{
    return this.map { it.mapToDomain() }
}