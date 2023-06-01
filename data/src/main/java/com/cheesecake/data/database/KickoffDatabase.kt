package com.cheesecake.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cheesecake.data.local.daos.TeamsDao
import com.cheesecake.data.local.models.LocalTeam

@Database(
    entities = [LocalTeam::class],
    version = 1
) //TODO add all entities into the annotation

abstract class KickoffDatabase : RoomDatabase() {

    abstract fun getTeamsDoa(): TeamsDao

}
