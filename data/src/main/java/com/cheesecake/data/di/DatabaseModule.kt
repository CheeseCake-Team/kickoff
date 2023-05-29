package com.cheesecake.data.di

import android.content.Context
import androidx.room.Room
import com.cheesecake.data.database.KickoffDatabase
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
    fun provideMarvelDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, KickoffDatabase::class.java, "KICKOFF_DATABASE").build()

    //TODO provide all daos here
}
