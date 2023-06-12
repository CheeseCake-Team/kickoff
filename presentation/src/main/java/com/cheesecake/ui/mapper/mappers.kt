package com.cheesecake.ui.mapper

import com.cheesecake.domain.entity.Team
import com.cheesecake.ui.models.TeamUIState

fun Team.toUIModel(): TeamUIState {
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