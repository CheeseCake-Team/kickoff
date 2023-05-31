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

    //TODO Countries Repository
    //TODO Fixtures Repository
    //TODO League Repository
    //TODO Player Repository
    //TODO Predictions Repository
    //TODO Sidelined Repository
    //TODO Standings Repository
    //TODO Teams Repository
    //TODO Timezone Repository
    //TODO Transfers Repository
    //TODO Trophies Repository
    //TODO Venues Repository

}