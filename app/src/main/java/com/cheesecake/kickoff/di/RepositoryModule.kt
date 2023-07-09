package com.cheesecake.kickoff.di

import com.cheesecake.data.repository.IFootballRepositoryImpl
import com.cheesecake.domain.repository.IFootballRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideFootballRepository(footballRepository: IFootballRepositoryImpl): IFootballRepository
}