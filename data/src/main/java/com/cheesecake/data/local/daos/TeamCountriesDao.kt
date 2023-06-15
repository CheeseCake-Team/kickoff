package com.cheesecake.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cheesecake.data.local.models.TeamCountriesLocalDTO

@Dao
interface TeamCountriesDao {

    @Query("SELECT * FROM team_country_table")
    suspend fun getLocalCountries(): List<TeamCountriesLocalDTO>

    @Insert
    suspend fun addTeamCountries(teams:List<TeamCountriesLocalDTO>)

}