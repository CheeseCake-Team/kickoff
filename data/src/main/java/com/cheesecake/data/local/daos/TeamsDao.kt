package com.cheesecake.data.local.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.cheesecake.data.local.models.TeamLocalDto
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamsDao {

    @Query("SELECT * FROM team_table")
    fun getAllTeams(): Flow<List<TeamLocalDto>>

    @Upsert
    suspend fun upsertAll(tasks: List<TeamLocalDto>)

    @Query("DELETE FROM team_table")
    suspend fun deleteAll()

    @Upsert
    suspend fun updateOrInsertLeagueLocalDto(LeagueLocalDto: LeagueLocalDto)

    @Query("SELECT * FROM league_table where leagueId = :leagueId")
    suspend fun getLeagueById(leagueId: Int): LeagueLocalDto?

    @Query("DELETE FROM league_table where isFavourite = 0")
    suspend fun deleteAllUnFavouriteLeagues()

}