package com.cheesecake.data.local.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.cheesecake.data.local.models.LeagueLocalDTO
import com.cheesecake.data.local.models.TeamLocalDTO
import kotlinx.coroutines.flow.Flow


@Dao
interface TeamsDao {

    @Query("SELECT * FROM team_table ")
    fun getLocallyTeamsByIdAndSeason(): List<TeamLocalDTO>

    @Upsert
    suspend fun updateOrInsertTeams(teams: List<TeamLocalDTO>)

    @Upsert
    suspend fun updateOrInsertTeam(team: TeamLocalDTO)

    @Query("DELETE FROM team_table")
    suspend fun deleteAllTeams()

    @Query("SELECT * FROM team_table WHERE isFavourite = 1")
    fun getFavouriteTeams(): Flow<List<TeamLocalDTO>>

    @Query("DELETE FROM team_table WHERE teamId = :teamId")
    suspend fun deleteTeamById(teamId: Int)

    @Query("SELECT * FROM team_table where teamId = :teamId ")
    suspend fun getTeamById(teamId: Int): TeamLocalDTO?
}