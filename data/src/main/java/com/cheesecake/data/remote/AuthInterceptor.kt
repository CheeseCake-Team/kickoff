package com.cheesecake.data.remote

import com.cheesecake.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = original.newBuilder()
            .header(API_HOST_HEADER, API_HOST_VALUE)
            .header(API_KEY_HEADER,  BuildConfig.PRIVATE_KEY)
            .build()
        return chain.proceed(request)
    }

    companion object {
        const val API_HOST_HEADER = "x-rapidapi-host"
        const val API_HOST_VALUE = "v3.football.api-sports.io"
        const val API_KEY_HEADER = "x-apisports-key"
    }
}