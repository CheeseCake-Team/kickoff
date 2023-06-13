package com.cheesecake.data.local.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.cheesecake.data.local.models.PlayerLocalDto
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {

    @Upsert
    suspend fun updateOrInsertPlayers(players: List<PlayerLocalDto>)

    @Upsert
    suspend fun updateOrInsertPlayer(player: PlayerLocalDto)

    @Query("DELETE FROM player_table")
    suspend fun deleteAllPlayers()

    @Query("SELECT * FROM player_table WHERE isFavourite = 1")
    fun getFavouritePlayers(): Flow<List<PlayerLocalDto>>

    @Query("DELETE FROM player_table WHERE playerId = :playerId")
    suspend fun deletePlayerById(playerId: Int)
}