package com.cheesecake.data.repository.models.dto

import com.cheesecake.domain.Entity.Player
import com.google.gson.annotations.SerializedName

data class PlayerDTO(
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
        val birth: com.cheesecake.data.repository.models.base.BaseBirth,
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
        val team: com.cheesecake.data.repository.models.base.Team,
        @SerializedName("league")
        val league: com.cheesecake.data.repository.models.base.LeagueCountrySeason,
        @SerializedName("games")
        val games: Games,
        @SerializedName("substitutes")
        val substitutes: Substitutes,
        @SerializedName("shots")
        val shots: com.cheesecake.data.repository.models.base.Shots,
        @SerializedName("goals")
        val goals: com.cheesecake.data.repository.models.base.GoalsState,
        @SerializedName("passes")
        val passes: com.cheesecake.data.repository.models.base.Passes,
        @SerializedName("tackles")
        val tackles: com.cheesecake.data.repository.models.base.Tackles,
        @SerializedName("duels")
        val duels: com.cheesecake.data.repository.models.base.Duels,
        @SerializedName("dribbles")
        val dribbles: com.cheesecake.data.repository.models.base.Dribbles,
        @SerializedName("fouls")
        val fouls: com.cheesecake.data.repository.models.base.Fouls,
        @SerializedName("cards")
        val cards: com.cheesecake.data.repository.models.base.Cards,
        @SerializedName("penalty")
        val penalty: com.cheesecake.data.repository.models.base.Penalty
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


fun PlayerDTO.mapToDomain(): Player{
    return Player(

    )
}

fun List<PlayerDTO>.mapToDomain():List<Player>{
    return this.map { it.mapToDomain() }
}