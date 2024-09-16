package com.cheesecake.data.local.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cheesecake.data.local.models.CompetitionLocalDto
import com.cheesecake.data.local.models.FavoriteCompetition
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteCompetitionDao {
    @Delete
    suspend fun deleteFavoriteCompetition(favoriteCompetition: FavoriteCompetition)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteCompetition(favoriteCompetition: FavoriteCompetition)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteCompetitions(favoriteCompetitions: List<FavoriteCompetition>)

    @Query("""
        SELECT competition.* FROM competition
        INNER JOIN favorite_competition ON competition.id = favorite_competition.competitionId
    """)
    fun getFavouriteCompetitions(): Flow<List<CompetitionLocalDto>>
}