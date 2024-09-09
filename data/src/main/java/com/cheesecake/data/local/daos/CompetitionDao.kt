package com.cheesecake.data.local.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.cheesecake.data.local.models.CompetitionLocalDto

@Dao
interface CompetitionDao {
    @Upsert
    suspend fun upsertCompetitionLocalDto(competitionLocalDto: CompetitionLocalDto)

    @Query("DELETE FROM competition WHERE id = :competitionId")
    suspend fun deleteCompetitionById(competitionId: Int)

    @Query("SELECT * FROM competition where id = :competitionId")
    suspend fun getCompetitionById(competitionId: Int): CompetitionLocalDto?

    @Upsert
    suspend fun insertCompetitions(competitionsLocalDto : List<CompetitionLocalDto>)
}