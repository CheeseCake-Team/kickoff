package com.cheesecake.data.remote.response

import com.cheesecake.data.remote.models.BaseBirthDTO
import com.cheesecake.data.remote.models.CardsDTO
import com.cheesecake.data.remote.models.DribblesDTO
import com.cheesecake.data.remote.models.DuelsDTO
import com.cheesecake.data.remote.models.FoulsDTO
import com.cheesecake.data.remote.models.GoalsStateDTO
import com.cheesecake.data.remote.models.LeagueCountrySeasonDTO
import com.cheesecake.data.remote.models.PassesDTO
import com.cheesecake.data.remote.models.PenaltyDTO
import com.cheesecake.data.remote.models.ShotsDTO
import com.cheesecake.data.remote.models.TacklesDTO
import com.cheesecake.data.remote.models.TeamDTO
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
        val birth: com.cheesecake.data.remote.models.BaseBirthDTO,
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
        val team: com.cheesecake.data.remote.models.TeamDTO,
        @SerializedName("league")
        val league: com.cheesecake.data.remote.models.LeagueCountrySeasonDTO,
        @SerializedName("games")
        val games: Games,
        @SerializedName("substitutes")
        val substitutes: Substitutes,
        @SerializedName("shots")
        val shots: com.cheesecake.data.remote.models.ShotsDTO,
        @SerializedName("goals")
        val goals: com.cheesecake.data.remote.models.GoalsStateDTO,
        @SerializedName("passes")
        val passes: com.cheesecake.data.remote.models.PassesDTO,
        @SerializedName("tackles")
        val tackles: com.cheesecake.data.remote.models.TacklesDTO,
        @SerializedName("duels")
        val duels: com.cheesecake.data.remote.models.DuelsDTO,
        @SerializedName("dribbles")
        val dribbles: com.cheesecake.data.remote.models.DribblesDTO,
        @SerializedName("fouls")
        val fouls: com.cheesecake.data.remote.models.FoulsDTO,
        @SerializedName("cards")
        val cards: com.cheesecake.data.remote.models.CardsDTO,
        @SerializedName("penalty")
        val penalty: com.cheesecake.data.remote.models.PenaltyDTO
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

fun PlayerDTO.mapToDomain(): PlayerStatisticsEntity {
    return PlayerStatisticsEntity(
        id = this.player.id,
        name = this.player.name,
        firstname = this.player.firstname,
        lastname = this.player.lastname,
        age = this.player.age,
        date = this.player.birth.date,
        place = this.player.birth.place,
        country = this.player.birth.country,
        nationality = this.player.nationality,
        height = this.player.height,
        weight = this.player.weight,
        injured = this.player.injured,
        appearences = this.statistics.first().games.appearences,
        lineups = this.statistics.first().games.lineups,
        minutes = this.statistics.first().games.minutes,
        number = this.statistics.first().games.number,
        position = this.statistics.first().games.position,
        rating = this.statistics.first().games.rating,
        captain = this.statistics.first().games.captain,
        photo = this.player.photo
    )
}

fun List<PlayerResponse>.mapToDomain():List<PlayerEntity>{
    return this.map { it.mapToDomain() }
}