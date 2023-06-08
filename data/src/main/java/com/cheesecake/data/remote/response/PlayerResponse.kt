package com.cheesecake.data.remote.response

import com.cheesecake.domain.entity.PlayerStatisticsEntity
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