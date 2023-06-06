package com.cheesecake.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cheesecake.data.local.models.FavouriteTeamLocalDto
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteTeamDao {

    @Query("SELECT * FROM team_table")
    fun getFavTeams(): Flow<List<FavouriteTeamLocalDto>>

    @Insert
    suspend fun insertTeam(favouriteTeamLocalDto: FavouriteTeamLocalDto)

    @Query("DELETE FROM team_table")
    suspend fun deleteAll()

}