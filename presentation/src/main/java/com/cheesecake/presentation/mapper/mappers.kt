package com.cheesecake.presentation.mapper

import com.cheesecake.domain.entity.Team
import com.cheesecake.presentation.models.TeamUIState

fun Team.toUIState(): TeamUIState {
    return TeamUIState(
        teamId = this.id,
        teamName= this.name,
        founded= this.yearFounded,
        teamCountry= this.country,
        venueCapacity= this.stadiumCapacity,
        venueName= this.stadiumName,
        imageUrl= this.imageUrl,
        isFavourite= this.isFavourite,
    )
}