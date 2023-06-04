package com.cheesecake.data.repository.countries

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.TeamCountriesDTO
import javax.inject.Inject
import retrofit2.Response

class CountriesRepository @Inject constructor (private val countriesApiService: ICountriesApiService) {
    suspend fun getAllCountries(): Response<BaseResponse<TeamCountriesDTO>> {
        return countriesApiService.getAllCountries()
    }

    suspend fun getCountryByName(countryName: String): Response<BaseResponse<TeamCountriesDTO>> {
        return countriesApiService.getCountryByName(countryName)
    }

    suspend fun getCountryByCode(countryCode: String): Response<BaseResponse<TeamCountriesDTO>> {
        return countriesApiService.getCountryByCode(countryCode)
    }

    suspend fun searchInCountries(searchQuery: String): Response<BaseResponse<TeamCountriesDTO>> {
        return countriesApiService.searchInCountries(searchQuery)
    }
}
