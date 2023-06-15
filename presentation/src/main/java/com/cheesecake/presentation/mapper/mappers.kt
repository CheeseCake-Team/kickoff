package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.Team
import com.cheesecake.domain.entity.TeamCountry
import com.cheesecake.presentation.models.TeamCountryUIState
import com.cheesecake.presentation.models.TeamUIState

fun Team.toUIModel(): TeamUIState {
    return TeamUIState(
        teamId = this.id,
        teamName = this.name,
        founded = this.yearFounded,
        teamCountry = this.country,
        venueCapacity = this.stadiumCapacity,
        venueName = this.stadiumName,
        imageUrl = this.imageUrl,
        isFavourite = this.isFavourite,
    )
}


fun TeamCountry.toUIModel(): TeamCountryUIState {
    return TeamCountryUIState(
        name = name,
        flag = flag
    )
}