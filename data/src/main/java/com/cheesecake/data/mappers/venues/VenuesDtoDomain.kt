package com.cheesecake.data.mappers.venues

import com.cheesecake.data.models.dto.VenuesDTO
import com.cheesecake.data.mappers.IMapper
import com.cheesecake.domain.models.Venue

class VenuesDtoDomain : IMapper<VenuesDTO, Venue> {
    override fun map(input: VenuesDTO): Venue {
        return Venue(
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