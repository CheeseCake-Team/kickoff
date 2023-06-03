package com.cheesecake.data.di

import com.cheesecake.data.local.dataSource.LocalDataSource
import com.cheesecake.data.local.dataSource.LocalDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindChatDataSource(
        localDataSource: LocalDataSourceImp
    ): LocalDataSource


}