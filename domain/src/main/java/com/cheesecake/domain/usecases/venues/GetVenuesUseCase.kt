package com.cheesecake.domain.usecases.venues

import com.cheesecake.data.models.VenuesResponse
import com.cheesecake.domain.mappers.VenuesDtoToSingleVenueDomain
import com.cheesecake.domain.models.SingleVenue
import javax.inject.Inject

class GetVenuesUseCase
@Inject constructor(private val venuesRepository: VenuesRepository){

    suspend operator fun invoke(venueId: Int) : SingleVenue{
        val dtoResponse = getVenuesResponse(venueId)
        return mapResponseIntoShort(dtoResponse!!)
    }

    private suspend fun getVenuesResponse(venueId : Int): VenuesResponse? {
        return venuesRepository.getVenueById(venueId).body()?.response?.get(0)
    }

    private fun mapResponseIntoShort(input: VenuesResponse): SingleVenue {
        return VenuesDtoToSingleVenueDomain().map(input)
    }
}