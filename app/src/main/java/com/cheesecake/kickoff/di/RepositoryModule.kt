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
    abstract fun provideFootballRepository(footballRepository: IFootballRepositoryImpl)
            : IFootballRepository


}


//object RepositoryModule {
//
//
//    @Binds
//    abstract fun provideFixturesRepository(fixturesRepositoryImpl: FixturesRepositoryImpl)
//            : FixturesRepositoryImpl
//
//
//    @Singleton
//    @Provides
//    fun provideCoachRepository(coachApiService: ICoachApiService): CoachRepository {
//        return CoachRepository(coachApiService)
//    }
//
//    @Singleton
//    @Provides
//    fun provideCountriesRepository(countriesApiService: ICountriesApiService): CountriesRepository {
//        return CountriesRepository(countriesApiService)
//    }
//
//
//    @Singleton
//    @Provides
//    fun provideLeagueRepository(leagueApiService: ILeaguesApiService): LeagueRepository {
//        return LeagueRepository(leagueApiService)
//    }
//
//    @Singleton
//    @Provides
//    fun providePlayerRepository(playersApiService: IPlayersApiService): PlayerRepository {
//        return PlayerRepository(playersApiService)
//    }
//
//    @Singleton
//    @Provides
//    fun providePredictionsRepository(predictionsApiService: IPredictionsApiService): PredictionsRepository {
//        return PredictionsRepository(predictionsApiService)
//    }
//
//    @Singleton
//    @Provides
//    fun provideSidelinedRepository(sidelinedApiService: ISidelinedApiService): SidelinedRepository {
//        return SidelinedRepository(sidelinedApiService)
//    }
//
//    @Singleton
//    @Provides
//    fun provideStandingsRepository(standingsApiService: IStandingsApiService): StandingsRepository {
//        return StandingsRepository(standingsApiService)
//    }
//
//    @Singleton
//    @Provides
//    fun provideTeamsRepository(
//        localDataSource: LocalDataSource,
//        remoteDataSource: RemoteDataSource,
//        @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
//    ): TeamsRepository {
//        return TeamsRepository(localDataSource, remoteDataSource, defaultDispatcher)
//    }
//
//    @Singleton
//    @Provides
//    fun provideTimezoneRepository(timezoneApiService: ITimeZoneApiService): TimeZoneRepository {
//        return TimeZoneRepository(timezoneApiService)
//    }
//
//    @Singleton
//    @Provides
//    fun provideTransfersRepository(transferApiService: ITransferApiService): TransfersRepository {
//        return TransfersRepository(transferApiService)
//    }
//
//    @Singleton
//    @Provides
//    fun provideTrophiesRepository(trophiesApiService: ITrophiesApiService): TrophiesRepository {
//        return TrophiesRepository(trophiesApiService)
//    }
//
//    @Singleton
//    @Provides
//    fun provideVenuesRepository(venuesApiService: IVenuesApiService): VenuesRepository {
//        return VenuesRepository(venuesApiService)
//    }
//
//    @Singleton
//    @Provides
//    fun provideInjuriesRepository(injuriesApiService: IInjuriesApiService): InjuriesRepository {
//        return InjuriesRepository(injuriesApiService)
//    }
//
//}