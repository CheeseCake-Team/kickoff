package com.cheesecake.data.repository.countries

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.TeamCountriesDTO
import com.cheesecake.data.remote.RemoteDataSource
import javax.inject.Inject
import retrofit2.Response

class CountriesRepository @Inject constructor (private val remoteDataSource: RemoteDataSource) {
    suspend fun getAllCountries(): List<TeamCountriesDTO> {
        return remoteDataSource.getAllCountries()
    }

    suspend fun getCountryByName(countryName: String): List<TeamCountriesDTO> {
        return remoteDataSource.getCountryByName(countryName)
    }

    suspend fun getCountryByCode(countryCode: String): List<TeamCountriesDTO> {
        return remoteDataSource.getCountryByCode(countryCode)
    }

    suspend fun searchInCountries(searchQuery: String): List<TeamCountriesDTO> {
        return remoteDataSource.searchInCountries(searchQuery)
    }
}
