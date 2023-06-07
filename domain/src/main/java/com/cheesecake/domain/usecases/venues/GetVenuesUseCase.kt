package com.cheesecake.domain.usecases.venues

import javax.inject.Inject

class GetVenuesUseCase
@Inject constructor(private val iFootballRepository: IFootballRepository) {

//    suspend operator fun invoke(venueId: Int): Venue {
//        val dtoResponse = getVenuesResponse(venueId)
//        return mapResponseIntoShort(dtoResponse!!)
//    }
//
//    private suspend fun getVenuesResponse(venueId: Int): VenuesDTO? {
//        return venuesRepository.getVenueById(venueId).body()?.response?.get(0)
//    }
//
//    private fun mapResponseIntoShort(input: VenuesDTO): Venue {
//        return VenuesDtoDomain().map(input)
//    }
}