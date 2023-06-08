package com.cheesecake.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cheesecake.data.local.daos.LeagueDao
import com.cheesecake.data.local.daos.TeamsDao
import com.cheesecake.data.local.models.LeagueLocalDto
import com.cheesecake.data.local.models.PlayerLocalDto
import com.cheesecake.data.local.models.TeamLocalDto

@Database(
    entities = [TeamLocalDto::class, LeagueLocalDto::class, PlayerLocalDto::class],
    version = 1
) //TODO add all entities into the annotation

abstract class KickoffDatabase : RoomDatabase() {

    abstract fun getTeamsDao(): TeamsDao

    abstract fun getLeagueDao(): LeagueDao

    abstract fun getPlayerDao(): LeagueDao
}
