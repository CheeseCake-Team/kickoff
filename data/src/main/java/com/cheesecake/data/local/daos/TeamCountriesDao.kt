package com.cheesecake.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cheesecake.data.local.models.TeamCountriesLocalDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamCountriesDao {

    @Query("SELECT * FROM team_country_table")
    suspend fun getLocalCountries(): List<TeamCountriesLocalDTO>

    @Insert
    suspend fun addTeamCountries(teams: List<TeamCountriesLocalDTO>)

    @Query("SELECT * FROM team_country_table WHERE name LIKE '%' || :search || '%'")
    fun getCountriesSearch(search: String): Flow<List<TeamCountriesLocalDTO>>

}