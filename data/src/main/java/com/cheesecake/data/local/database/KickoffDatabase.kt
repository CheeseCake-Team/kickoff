package com.cheesecake.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cheesecake.data.local.daos.TeamsDao
import com.cheesecake.data.local.models.TeamLocalDto

@Database(
    entities = [TeamLocalDto::class],
    version = 1
) //TODO add all entities into the annotation

abstract class KickoffDatabase : RoomDatabase() {

    abstract fun getTeamsDoa(): TeamsDao

}
