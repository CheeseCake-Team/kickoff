package com.cheesecake.data.remote.venues

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.VenuesDTO
import retrofit2.Response
import javax.inject.Inject

class VenuesRepository @Inject constructor (private val venuesApiService: IVenuesApiService) {

    suspend fun getVenueById(venueId: Int): Response<BaseResponse<VenuesDTO>> {
        return venuesApiService.getVenueById(venueId)
    }

    suspend fun getVenueByName(venueName: String): Response<BaseResponse<VenuesDTO>> {
        return venuesApiService.getVenueByName(venueName)
    }

    suspend fun getVenuesByCityName(cityName: String): Response<BaseResponse<VenuesDTO>> {
        return venuesApiService.getVenuesByCityName(cityName)
    }

    suspend fun getVenuesByCountryName(countryName: String): Response<BaseResponse<VenuesDTO>> {
        return venuesApiService.getVenuesByCountryName(countryName)
    }

    suspend fun searchVenueByName(venueName: String): Response<BaseResponse<VenuesDTO>> {
        return venuesApiService.searchVenue(venueName)
    }

}
