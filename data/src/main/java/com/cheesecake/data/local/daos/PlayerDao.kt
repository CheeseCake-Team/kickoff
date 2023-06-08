package com.cheesecake.data.local.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.cheesecake.data.local.models.PlayerLocalDto

@Dao
interface PlayerDao {

    @Query("SELECT * FROM player_table WHERE playerId = :playerId")
    fun getLocallyPlayer(playerId: Int): List<PlayerLocalDto>

    @Upsert
    suspend fun updateOrInsertPlayers(players: List<PlayerLocalDto>)

    @Upsert
    suspend fun updateOrInsertPlayer(player: PlayerLocalDto)

    @Query("DELETE FROM player_table")
    suspend fun deleteAllPlayers()

    @Query("SELECT * FROM player_table WHERE isFavourite = 1")
    suspend fun getFavouritePlayers(): List<PlayerLocalDto>

    @Query("DELETE FROM player_table WHERE playerId = :playerId")
    suspend fun deletePlayerById(playerId: Int)
}