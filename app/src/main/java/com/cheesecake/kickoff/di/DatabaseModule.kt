package com.cheesecake.kickoff.di

import android.content.Context
import androidx.room.Room
import com.cheesecake.data.local.daos.LeagueDao
import com.cheesecake.data.local.daos.TeamCountriesDao
import com.cheesecake.data.local.daos.RecentSearchDao
import com.cheesecake.data.local.daos.TeamsDao
import com.cheesecake.data.local.database.KickoffDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideKickoffDatabase(@ApplicationContext context: Context): KickoffDatabase =
        Room.databaseBuilder(context, KickoffDatabase::class.java, "KICKOFF_DATABASE").build()

    //TODO provide all daos here

    @Singleton
    @Provides
    fun provideTeamsDoa(kickoffDatabase: KickoffDatabase): TeamsDao =
        kickoffDatabase.getTeamsDao()

    @Singleton
    @Provides
    fun provideLeagueDoa(kickoffDatabase: KickoffDatabase): LeagueDao =
        kickoffDatabase.getLeagueDao()

    @Singleton
    @Provides
    fun provideSearchResultDao(kickoffDatabase: KickoffDatabase): RecentSearchDao =
        kickoffDatabase.getSearchResultDao()

    @Singleton
    @Provides
    fun provideTeamCountriesDao(kickoffDatabase: KickoffDatabase): TeamCountriesDao =
        kickoffDatabase.getTeamCountriesDao()

}
