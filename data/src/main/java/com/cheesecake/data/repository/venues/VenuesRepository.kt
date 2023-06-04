package com.cheesecake.data.repository.venues

import com.cheesecake.data.models.dto.VenuesDTO
import com.cheesecake.data.remote.RemoteDataSource
import javax.inject.Inject

class VenuesRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun getVenueById(venueId: Int): List<VenuesDTO> {
        return remoteDataSource.getVenueById(venueId)
    }

    suspend fun getVenueByName(venueName: String): List<VenuesDTO> {
        return remoteDataSource.getVenueByName(venueName)
    }

    suspend fun getVenuesByCityName(cityName: String): List<VenuesDTO> {
        return remoteDataSource.getVenuesByCityName(cityName)
    }

    suspend fun getVenuesByCountryName(countryName: String): List<VenuesDTO> {
        return remoteDataSource.getVenuesByCountryName(countryName)
    }

    suspend fun searchVenueByName(venueName: String): List<VenuesDTO> {
        return remoteDataSource.searchVenue(venueName)
    }

}
