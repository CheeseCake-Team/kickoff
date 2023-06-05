package com.cheesecake.data.local.daos

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.cheesecake.data.local.models.LeagueLocalDto
import io.reactivex.rxjava3.core.Completable
import kotlinx.coroutines.flow.Flow

interface LeagueDao {


    @Query("SELECT * FROM league_table")
    fun getLeague(): Flow<List<LeagueLocalDto>>

    @Insert
    suspend fun insertLeague(league_dto: LeagueLocalDto)

    @Query("DELETE FROM league_table")
    suspend fun deleteAll()


}