package com.cheesecake.data.local.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.cheesecake.data.local.models.RecentSearchLocalDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface RecentSearchDao {

    @Upsert
    suspend fun updateOrInsertRecentSearch(result: RecentSearchLocalDTO)

    @Query("DELETE FROM recentSearch_table WHERE id = :recentId")
    suspend fun deleteRecentSearchById(recentId: Int)

    @Query("DELETE FROM recentSearch_table")
    suspend fun deleteRecentSearches()

    @Query("SELECT * FROM recentSearch_table ORDER BY rank DESC")
    fun getAllRecentSearches(): Flow<List<RecentSearchLocalDTO>>

}