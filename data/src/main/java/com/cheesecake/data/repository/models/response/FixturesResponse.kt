package com.cheesecake.data.repository.models.response

import com.cheesecake.data.repository.models.dto.BaseGoalsDTO
import com.cheesecake.data.repository.models.dto.CardsDTO
import com.cheesecake.data.repository.models.dto.DribblesDTO
import com.cheesecake.data.repository.models.dto.DuelsDTO
import com.cheesecake.data.repository.models.dto.FixtureDTO
import com.cheesecake.data.repository.models.dto.FoulsDTO
import com.cheesecake.data.repository.models.dto.GoalsStateDTO
import com.cheesecake.data.repository.models.dto.LeagueCountrySeasonRoundDTO
import com.cheesecake.data.repository.models.dto.PassesDTO
import com.cheesecake.data.repository.models.dto.PenaltyDTO
import com.cheesecake.data.repository.models.dto.PersonPhotoDTO
import com.cheesecake.data.repository.models.dto.PlayerColorDTO
import com.cheesecake.data.repository.models.dto.PlayerMetaDTO
import com.cheesecake.data.repository.models.dto.PlayerPosGridDTO
import com.cheesecake.data.repository.models.dto.ScoreBlockDTO
import com.cheesecake.data.repository.models.dto.ShotsDTO
import com.cheesecake.data.repository.models.dto.TacklesDTO
import com.cheesecake.data.repository.models.dto.TeamDTO
import com.cheesecake.data.repository.models.dto.TeamHomeAwayDTO
import com.cheesecake.data.repository.models.dto.TimeMetaDTO
import com.google.gson.annotations.SerializedName

data class FixturesResponse(
    @SerializedName("fixture")
    val fixtureDTO: FixtureDTO,
    @SerializedName("league")
    val league: LeagueCountrySeasonRoundDTO,
    @SerializedName("teams")
    val teams: TeamHomeAwayDTO,
    @SerializedName("goals")
    val goals: BaseGoalsDTO,
    @SerializedName("score")
    val score: ScoreBlockDTO,
    @SerializedName("events")
    val events: List<Event>,
    @SerializedName("lineups")
    val lineups: List<Lineup>,
    @SerializedName("statistics")
    val statistics: List<Statistic>,
    @SerializedName("players")
    val players: List<Player>
) {
    data class Event(
        @SerializedName("time")
        val time: TimeMetaDTO,
        @SerializedName("team")
        val team: TeamDTO,
        @SerializedName("player")
        val player: PlayerMetaDTO,
        @SerializedName("assist")
        val assist: PlayerMetaDTO,
        @SerializedName("type")
        val type: String,
        @SerializedName("detail")
        val detail: String,
        @SerializedName("comments")
        val comments: String
    )

    data class Lineup(
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
            val colors: PlayerColorDTO
        )
    }

    data class StartXI(
        @SerializedName("player")
        val player: PlayerPosGridDTO
    )

    data class Substitute(
        @SerializedName("player")
        val player: PlayerPosGridDTO
    )

    data class Statistic(
        @SerializedName("team")
        val team: TeamDTO,
        @SerializedName("statistics")
        val statistics: List<Statistic>
    ) {
        data class Statistic(
            @SerializedName("type")
            val type: String,
            @SerializedName("value")
            val value: Int
        )
    }

    data class Player(
        @SerializedName("team")
        val team: Team,
        @SerializedName("players")
        val players: List<Player>
    ) {
        data class Team(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("logo")
            val logo: String,
            @SerializedName("update")
            val update: String
        )

        data class Player(
            @SerializedName("player")
            val player: PersonPhotoDTO,
            @SerializedName("statistics")
            val statistics: List<Statistic>
        ) {
            data class Statistic(
                @SerializedName("games")
                val games: Games,
                @SerializedName("offsides")
                val offsides: Int,
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
                    @SerializedName("minutes")
                    val minutes: Int,
                    @SerializedName("number")
                    val number: Int,
                    @SerializedName("position")
                    val position: String,
                    @SerializedName("rating")
                    val rating: String,
                    @SerializedName("captain")
                    val captain: Boolean,
                    @SerializedName("substitute")
                    val substitute: Boolean
                )
            }
        }
    }
}

