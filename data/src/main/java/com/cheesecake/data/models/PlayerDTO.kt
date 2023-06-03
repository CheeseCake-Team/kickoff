package com.cheesecake.data.models

import com.cheesecake.data.models.base.BaseBirth
import com.cheesecake.data.models.base.Cards
import com.cheesecake.data.models.base.Dribbles
import com.cheesecake.data.models.base.Duels
import com.cheesecake.data.models.base.Fouls
import com.cheesecake.data.models.base.GoalsState
import com.cheesecake.data.models.base.LeagueCountrySeason
import com.cheesecake.data.models.base.Passes
import com.cheesecake.data.models.base.Penalty
import com.cheesecake.data.models.base.Shots
import com.cheesecake.data.models.base.Tackles
import com.cheesecake.data.models.base.Team
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
        val birth: BaseBirth,
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
        val team: Team,
        @SerializedName("league")
        val league: LeagueCountrySeason,
        @SerializedName("games")
        val games: Games,
        @SerializedName("substitutes")
        val substitutes: Substitutes,
        @SerializedName("shots")
        val shots: Shots,
        @SerializedName("goals")
        val goals: GoalsState,
        @SerializedName("passes")
        val passes: Passes,
        @SerializedName("tackles")
        val tackles: Tackles,
        @SerializedName("duels")
        val duels: Duels,
        @SerializedName("dribbles")
        val dribbles: Dribbles,
        @SerializedName("fouls")
        val fouls: Fouls,
        @SerializedName("cards")
        val cards: Cards,
        @SerializedName("penalty")
        val penalty: Penalty
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