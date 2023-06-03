package com.cheesecake.domain.mappers.venues

import com.cheesecake.data.models.dto.VenuesDTO
import com.cheesecake.domain.mappers.IMapper
import com.cheesecake.domain.models.venues.SingleVenue

class VenuesDtoDomain : IMapper<VenuesDTO, SingleVenue> {
    override fun map(input: VenuesDTO): SingleVenue {
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