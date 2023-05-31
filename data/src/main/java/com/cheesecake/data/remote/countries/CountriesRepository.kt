package com.cheesecake.data.remote.countries

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.TeamCountries
import javax.inject.Inject
import retrofit2.Response

class CountriesRepository @Inject constructor (private val countriesApiService: ICountriesApiService) {
    suspend fun getAllCountries(): Response<BaseResponse<TeamCountries>> {
        return countriesApiService.getAllCountries()
    }

    suspend fun getCountryByName(countryName: String): Response<BaseResponse<TeamCountries>> {
        return countriesApiService.getCountryByName(countryName)
    }

    suspend fun getCountryByCode(countryCode: String): Response<BaseResponse<TeamCountries>> {
        return countriesApiService.getCountryByCode(countryCode)
    }

    suspend fun searchInCountries(searchQuery: String): Response<BaseResponse<TeamCountries>> {
        return countriesApiService.searchInCountries(searchQuery)
    }
}
