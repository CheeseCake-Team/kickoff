package com.cheesecake.data.remote.models

import com.cheesecake.data.remote.models.*
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
        val birth: BaseBirthDTO,
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
        val team: TeamDataDTO,
        @SerializedName("league")
        val league: LeagueCountrySeasonDTO,
        @SerializedName("games")
        val games: Games,
        @SerializedName("substitutes")
        val substitutes: Substitutes,
        @SerializedName("shots")
        val shots: ShotsDTO,
        @SerializedName("goals")
        val goals: GoalsStateDTO,
        @SerializedName("passes")
        val passes: PassesDTO,
        @SerializedName("tackles")
        val tackles: TacklesDTO,
        @SerializedName("duels")
        val duels: DuelsDTO,
        @SerializedName("dribbles")
        val dribbles: DribblesDTO,
        @SerializedName("fouls")
        val fouls: FoulsDTO,
        @SerializedName("cards")
        val cards: CardsDTO,
        @SerializedName("penalty")
        val penalty: PenaltyDTO
    ) {

        data class Games(
            @SerializedName("appearences")
            val appearences: Int,
            @SerializedName("lineups")
            val lineups: Int,
            @SerializedName("minutes")
            val minutes: Int,
            @SerializedName("number")
            val number: Int,
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