package com.cheesecake.domain.mappers.venues

import com.cheesecake.data.models.VenuesResponse
import com.cheesecake.domain.mappers.IMapper
import com.cheesecake.domain.models.SingleVenue

class VenuesDtoDomain : IMapper<VenuesResponse, SingleVenue> {
    override fun map(input: VenuesResponse): SingleVenue {
        return SingleVenue(
            name = input.name,
            address = input.address,
            city = input.city,
            country = input.country,
            capacity = input.capacity,
            surface = input.surface,
            image = input.image
        )
    }
}