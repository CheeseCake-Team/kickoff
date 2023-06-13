package com.cheesecake.data.repository.mappers

import com.cheesecake.data.local.models.CountryLocalDto
import com.cheesecake.domain.entity.Country

@JvmName("CountryToCountryLocalDTO")
fun Country.toLocal(): CountryLocalDto = CountryLocalDto(
    countryId = countryId,
    name = name ,
    flagImageUrl = flag
)

