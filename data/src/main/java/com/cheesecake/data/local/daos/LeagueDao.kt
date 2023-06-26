package com.cheesecake.data.local.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.cheesecake.data.local.models.LeagueLocalDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface LeagueDao {

    @Upsert
    suspend fun updateOrInsertLeagueLocalDto(LeagueLocalDto: LeagueLocalDTO)

    @Query("DELETE FROM league_table WHERE leagueId = :leagueId")
    suspend fun deleteLeagueById(leagueId: Int)

    @Query("SELECT * FROM league_table where leagueId = :leagueId ")
    suspend fun getLeagueByIdAndSeason(leagueId: Int, ): LeagueLocalDTO?

    @Query("SELECT * FROM league_table WHERE isFavourite = 1")
    fun getFavouriteLeagues(): Flow<List<LeagueLocalDTO>>

}