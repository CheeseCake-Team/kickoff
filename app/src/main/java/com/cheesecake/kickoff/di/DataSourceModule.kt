package com.cheesecake.kickoff.di

import com.cheesecake.data.local.LocalDataSource
import com.cheesecake.data.local.LocalDataSourceImp
import com.cheesecake.data.remote.RemoteDataSource
import com.cheesecake.data.remote.RemoteDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindLocalDataSource(
        localDataSourceImp: LocalDataSourceImp
    ): LocalDataSource

    @Binds
    abstract fun bindRemoteDataSource(
        remoteDataSourceImp: RemoteDataSourceImp
    ): RemoteDataSource


}