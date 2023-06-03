package com.cheesecake.domain.usecases.venues

import com.cheesecake.data.models.dto.VenuesDTO
import com.cheesecake.data.remote.venues.VenuesRepository
import com.cheesecake.domain.mappers.venues.VenuesDtoDomain
import com.cheesecake.domain.models.SingleVenue
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