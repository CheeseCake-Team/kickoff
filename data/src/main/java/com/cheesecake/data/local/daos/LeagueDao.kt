package com.cheesecake.data.local.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.cheesecake.data.local.models.LeagueLocalDTO

@Dao
interface LeagueDao {

    @Upsert
    suspend fun updateOrInsertLeagueLocalDto(LeagueLocalDto: LeagueLocalDTO)

    @Query("DELETE FROM league_table WHERE leagueId = :leagueId")
    suspend fun deleteLeagueById(leagueId: Int)

    @Query("SELECT * FROM league_table where leagueId = :leagueId And leagueSeason = :leagueSeason")
    suspend fun getLeagueByIdAndSeason(leagueId: Int, leagueSeason: Int): LeagueLocalDTO?

    @Upsert
    suspend fun insertLeagueList(LeaguesLocalDt0 : List<LeagueLocalDTO>)


}