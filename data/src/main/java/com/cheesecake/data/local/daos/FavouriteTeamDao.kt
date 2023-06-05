package com.cheesecake.data.local.daos

import androidx.room.Insert
import androidx.room.Query
import com.cheesecake.data.local.models.FavouriteTeamLocalDto
import com.cheesecake.data.local.models.TeamLocalDto
import kotlinx.coroutines.flow.Flow

interface FavouriteTeamDao {


    @Query("SELECT * FROM team_table")
    fun getFavTeams(): Flow<List<FavouriteTeamLocalDto>>

    @Insert
    suspend fun insertTeam(favouriteTeamLocalDto: FavouriteTeamLocalDto)

    @Query("DELETE FROM team_table")
    suspend fun deleteAll()

}