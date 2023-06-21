package com.cheesecake.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cheesecake.data.local.daos.LeagueDao
import com.cheesecake.data.local.daos.RecentSearchDao
import com.cheesecake.data.local.daos.TeamsDao
import com.cheesecake.data.local.models.LeagueLocalDTO
import com.cheesecake.data.local.models.RecentSearchLocalDTO
import com.cheesecake.data.local.models.TeamLocalDTO

@Database(
    entities = [TeamLocalDTO::class, LeagueLocalDTO::class, RecentSearchLocalDTO::class],
    version = 1
)

abstract class KickoffDatabase : RoomDatabase() {

    abstract fun getTeamsDao(): TeamsDao

    abstract fun getLeagueDao(): LeagueDao

    abstract fun getSearchResultDao(): RecentSearchDao

}
