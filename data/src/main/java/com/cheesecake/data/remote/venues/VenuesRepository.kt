package com.cheesecake.data.remote.venues

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.VenuesResponse
import retrofit2.Response
import javax.inject.Inject

class VenuesRepository @Inject constructor (private val venuesApiService: IVenuesApiService) {

    suspend fun getVenueById(venueId: Int): Response<BaseResponse<VenuesResponse>> {
        return venuesApiService.getVenueById(venueId)
    }

    suspend fun getVenueByName(venueName: String): Response<BaseResponse<VenuesResponse>> {
        return venuesApiService.getVenueByName(venueName)
    }

    suspend fun getVenuesByCityName(cityName: String): Response<BaseResponse<List<VenuesResponse>>> {
        return venuesApiService.getVenuesByCityName(cityName)
    }

    suspend fun getVenuesByCountryName(countryName: String): Response<BaseResponse<List<VenuesResponse>>> {
        return venuesApiService.getVenuesByCountryName(countryName)
    }

    suspend fun searchVenueByName(venueName: String): Response<BaseResponse<VenuesResponse>> {
        return venuesApiService.searchVenueByName(venueName)
    }

    suspend fun searchVenuesByCountryName(countryName: String): Response<BaseResponse<List<VenuesResponse>>> {
        return venuesApiService.searchVenuesByCountryName(countryName)
    }

    suspend fun searchVenuesByCityName(cityName: String): Response<BaseResponse<List<VenuesResponse>>> {
        return venuesApiService.searchVenuesByCityName(cityName)
    }
}
