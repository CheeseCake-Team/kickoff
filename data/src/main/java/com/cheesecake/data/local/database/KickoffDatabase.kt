package com.cheesecake.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cheesecake.data.local.daos.CompetitionDao
import com.cheesecake.data.local.daos.FavoriteCompetitionDao
import com.cheesecake.data.local.daos.RecentSearchDao
import com.cheesecake.data.local.daos.TeamCountriesDao
import com.cheesecake.data.local.daos.TeamsDao
import com.cheesecake.data.local.models.TeamCountriesLocalDTO
import com.cheesecake.data.local.models.CompetitionLocalDto
import com.cheesecake.data.local.models.FavoriteCompetition
import com.cheesecake.data.local.models.RecentSearchLocalDTO
import com.cheesecake.data.local.models.TeamLocalDTO

@Database(
    entities = [TeamLocalDTO::class, FavoriteCompetition::class, CompetitionLocalDto::class, TeamCountriesLocalDTO::class, RecentSearchLocalDTO::class],
    version = 1
)
abstract class KickoffDatabase : RoomDatabase() {
    abstract fun getTeamsDao(): TeamsDao

    abstract fun getLeagueDao(): CompetitionDao

    abstract fun getTeamCountriesDao(): TeamCountriesDao

    abstract fun getSearchResultDao(): RecentSearchDao

    abstract fun getFavoriteCompetitionDao(): FavoriteCompetitionDao
}