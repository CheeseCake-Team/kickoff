package com.cheesecake.data.local.daos

import androidx.room.Query
import androidx.room.Upsert
import com.cheesecake.data.local.models.LeagueLocalDto
import kotlinx.coroutines.flow.Flow

interface LeagueDao {


    @Query("SELECT * FROM league_table")
    fun getLeague(): Flow<List<LeagueLocalDto>>

    @Upsert
    suspend fun insertLeague(leagueDto: LeagueLocalDto)

    @Query("DELETE FROM league_table")
    suspend fun deleteAll()

    @Upsert
    suspend fun updateOrInsertLeagueLocalDto(LeagueLocalDto: LeagueLocalDto)

    @Query("SELECT * FROM league_table where leagueId = :leagueId And leagueSeason = :leagueSeason")
    suspend fun getLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): LeagueLocalDto?


}