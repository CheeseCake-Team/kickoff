package com.cheesecake.data.di

import com.cheesecake.data.dataSource.local.LocalDataSource
import com.cheesecake.data.dataSource.local.LocalDataSourceImp
import com.cheesecake.data.dataSource.remote.RemoteDataSource
import com.cheesecake.data.dataSource.remote.RemoteDataSourceImp
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