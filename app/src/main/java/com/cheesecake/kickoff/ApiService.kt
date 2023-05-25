package com.cheesecake.kickoff

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("timezone")
    fun getTimezone(): Observable<TimezoneResponse>

    @GET("countries")
    fun getCountries(): Observable<CountryResponse>




}