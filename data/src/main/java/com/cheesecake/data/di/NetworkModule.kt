package com.cheesecake.data.di

import com.cheesecake.data.BuildConfig
import com.cheesecake.data.remote.IFootballApiService
import com.cheesecake.data.remote.IPlayersApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
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
    fun provideRetrofitService(retrofit: Retrofit): IFootballApiService {
        return retrofit.create(IFootballApiService::class.java)
    }

    @Singleton
    @Provides
    fun providePlayerApiService(retrofit: Retrofit): IPlayersApiService {
        return retrofit.create(IPlayersApiService::class.java)
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
                    .header(API_KEY_HEADER,BuildConfig.my_private_key)
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