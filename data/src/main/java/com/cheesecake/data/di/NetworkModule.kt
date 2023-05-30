package com.cheesecake.data.di

import com.cheesecake.data.BuildConfig
import com.cheesecake.data.remote.ICoachApiService
import com.cheesecake.data.remote.IFixturesApiService
import com.cheesecake.data.remote.ICountriesApiService
import com.cheesecake.data.remote.IPlayersApiService
import com.cheesecake.data.remote.ISidelinedApiService
import com.cheesecake.data.remote.ITimeZoneApiService
import com.cheesecake.data.remote.ITeamsApiService
import com.cheesecake.data.remote.ITrophiesApiService
import com.cheesecake.data.remote.IVenuesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    const val API_HOST_HEADER = "x-rapidapi-host"
    const val API_HOST_VALUE = "v3.football.api-sports.io"
    const val API_KEY_HEADER = "x-rapidapi-key"

    //TODO write api service provider injection



    @Singleton
    @Provides
    fun provideRetrofitService(retrofit: Retrofit): ICountriesApiService {
        return retrofit.create(ICountriesApiService::class.java)
    }

    @Singleton
    @Provides
    fun providePlayerApiService(retrofit: Retrofit): IPlayersApiService {
        return retrofit.create(IPlayersApiService::class.java)
    }
    @Singleton
    @Provides
    fun provideFixtureApiService(retrofit: Retrofit): IFixturesApiService {
        return retrofit.create(IFixturesApiService::class.java)
    }
    @Singleton
    @Provides
    fun provideTimezoneApiService(retrofit: Retrofit): ITimeZoneApiService {
        return retrofit.create(ITimeZoneApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideTeamsApiService(retrofit: Retrofit): ITeamsApiService {
        return retrofit.create(ITeamsApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideVenuesApiService(retrofit: Retrofit): IVenuesApiService {
        return retrofit.create(IVenuesApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideCoachsApiService(retrofit: Retrofit): ICoachApiService {
        return retrofit.create(ICoachApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideTrophiesApiService(retrofit: Retrofit): ITrophiesApiService {
        return retrofit.create(ITrophiesApiService::class.java)
    }
      
      
    @Singleton
    @Provides
    fun provideSidelinedApiService(retrofit: Retrofit): ISidelinedApiService{
        return retrofit.create(ISidelinedApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(
        client: OkHttpClient,
        factory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://v3.football.api-sports.io/")
            .client(client)
            .addConverterFactory(factory)
            .build()
    }

    //TODO check how to import BuildConfigKey ???
    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor (Interceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .header(API_HOST_HEADER, API_HOST_VALUE)
                    .header(API_KEY_HEADER, BuildConfig.my_private_key)
                    .build()
                chain.proceed(request)
            })
            .build()
    }


    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

    @Singleton
    @Provides
    fun provideGson(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideRXJava3CallAdapterFactory(): RxJava3CallAdapterFactory =
        RxJava3CallAdapterFactory.create()
}