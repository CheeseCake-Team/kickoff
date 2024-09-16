package com.cheesecake.kickoff.di

import com.cheesecake.data.local.LocalDataSourceImp
import com.cheesecake.data.local.OnboardingDataSourceImpl
import com.cheesecake.data.local.SeasonLocalDataSourceImpl
import com.cheesecake.data.local.TimezoneLocalDataSourceImpl
import com.cheesecake.data.remote.RemoteDataSourceImp
import com.cheesecake.data.repository.LocalDataSource
import com.cheesecake.data.repository.OnboardingDataSource
import com.cheesecake.data.repository.RemoteDataSource
import com.cheesecake.data.repository.SeasonLocalDataSource
import com.cheesecake.data.repository.TimezoneLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindLocalDataSource(localDataSourceImp: LocalDataSourceImp): LocalDataSource

    @Binds
    abstract fun bindRemoteDataSource(remoteDataSourceImp: RemoteDataSourceImp): RemoteDataSource

    @Binds
    abstract fun bindOnboardingDataSource(onboardingDataSourceImpl: OnboardingDataSourceImpl): OnboardingDataSource

    @Binds
    abstract fun bindSeasonDataSource(seasonLocalDataSourceImpl: SeasonLocalDataSourceImpl): SeasonLocalDataSource

    @Binds
    abstract fun bindTimezoneDataSource(timezoneLocalDataSourceImpl: TimezoneLocalDataSourceImpl): TimezoneLocalDataSource
}