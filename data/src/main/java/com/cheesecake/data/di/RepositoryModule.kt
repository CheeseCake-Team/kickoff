package com.cheesecake.data.di

import com.cheesecake.data.remote.coach.CoachRepository
import com.cheesecake.data.remote.coach.ICoachApiService
import com.cheesecake.data.remote.countries.ICountriesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCoachRepository(coachApiService: ICoachApiService): CoachRepository {
        return CoachRepository(coachApiService)
    }

    @Singleton
    @Provides
    fun provideCountriesRepository(countriesApiService: ICountriesApiService): CountriesRepository {
        return CountriesRepository(countriesApiService)
    }

    @Singleton
    @Provides
    fun provideFixturesRepository(fixturesApiService: IFixturesApiService): FixturesRepository {
        return FixturesRepository(fixturesApiService)
    }

    @Singleton
    @Provides
    fun provideLeagueRepository(leagueApiService: ILeaguesApiService): LeagueRepository {
        return LeagueRepository(leagueApiService)
    }

    @Singleton
    @Provides
    fun providePlayerRepository(playersApiService: IPlayersApiService): PlayerRepository {
        return PlayerRepository(playersApiService)
    }

    @Singleton
    @Provides
    fun providePredictionsRepository(predictionsApiService: IPredictionsApiService): PredictionsRepository {
        return PredictionsRepository(predictionsApiService)
    }

    @Singleton
    @Provides
    fun provideSidelinedRepository(sidelinedApiService: ISidelinedApiService): SidelinedRepository {
        return SidelinedRepository(sidelinedApiService)
    }

    @Singleton
    @Provides
    fun provideStandingsRepository(standingsApiService: IStandingsApiService): StandingsRepository {
        return StandingsRepository(standingsApiService)
    }

    @Singleton
    @Provides
    fun provideTeamsRepository(teamsApiService: ITeamsApiService): TeamsRepository {
        return TeamsRepository(teamsApiService)
    }

    @Singleton
    @Provides
    fun provideTimezoneRepository(timezoneApiService: ITimeZoneApiService): TimeZoneRepository {
        return TimeZoneRepository(timezoneApiService)
    }

    @Singleton
    @Provides
    fun provideTransfersRepository(transferApiService: ITransferApiService): TransfersRepository {
        return TransfersRepository(transferApiService)
    }

    @Singleton
    @Provides
    fun provideTrophiesRepository(trophiesApiService: ITrophiesApiService): TrophiesRepository {
        return TrophiesRepository(trophiesApiService)
    }

    @Singleton
    @Provides
    fun provideVenuesRepository(venuesApiService: IVenuesApiService): VenuesRepository {
        return VenuesRepository(venuesApiService)
    }

    @Singleton
    @Provides
    fun provideInjuriesRepository(injuriesApiService: IInjuriesApiService): InjuriesRepository {
        return InjuriesRepository(injuriesApiService)
    }

}