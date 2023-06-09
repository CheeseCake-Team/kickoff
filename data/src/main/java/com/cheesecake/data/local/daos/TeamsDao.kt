package com.cheesecake.data.local.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.cheesecake.data.local.models.TeamLocalDTO

@Dao
interface TeamsDao {

    @Query("SELECT * FROM team_table WHERE leagueId = :leagueId AND season = :season")
    fun getLocallyTeamsByIdAndSeason(leagueId: Int, season: Int): List<TeamLocalDTO>

    @Upsert
    suspend fun updateOrInsertTeams(teams: List<TeamLocalDTO>)

    @Upsert
    suspend fun updateOrInsertTeam(team: TeamLocalDTO)

    @Query("DELETE FROM team_table")
    suspend fun deleteAllTeams()

    @Query("SELECT * FROM team_table WHERE isFavourite = 1")
    suspend fun getFavouriteTeams(): List<TeamLocalDTO>

}