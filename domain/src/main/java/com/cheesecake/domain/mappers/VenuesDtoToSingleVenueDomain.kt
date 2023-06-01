package com.cheesecake.domain.mappers

import com.cheesecake.data.models.VenuesResponse
import com.cheesecake.domain.models.SingleVenue

class VenuesDtoToSingleVenueDomain : IMapper<VenuesResponse ,SingleVenue> {
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