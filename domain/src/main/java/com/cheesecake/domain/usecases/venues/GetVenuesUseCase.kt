package com.cheesecake.domain.usecases.venues

import com.cheesecake.data.models.VenuesDTO
import com.cheesecake.domain.mappers.venues.VenuesDtoDomain
import com.cheesecake.domain.models.venues.SingleVenue
import javax.inject.Inject

class GetVenuesUseCase
@Inject constructor(private val venuesRepository: VenuesRepository){

    suspend operator fun invoke(venueId: Int): SingleVenue {
        val dtoResponse = getVenuesResponse(venueId)
        return mapResponseIntoShort(dtoResponse!!)
    }

    private suspend fun getVenuesResponse(venueId: Int): VenuesDTO? {
        return venuesRepository.getVenueById(venueId).body()?.response?.get(0)
    }

    private fun mapResponseIntoShort(input: VenuesDTO): SingleVenue {
        return VenuesDtoDomain().map(input)
    }
}