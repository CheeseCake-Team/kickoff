package com.cheesecake.ui.mapper

import com.cheesecake.domain.entity.TeamEntity
import com.cheesecake.ui.models.TeamUIState

fun TeamEntity.toUIModel(): TeamUIState {
    return TeamUIState(
        teamId = this.teamId,
        teamName= this.teamName,
        founded= this.founded,
        teamCountry= this.teamCountry,
        venueCapacity= this.venueCapacity,
        venueName= this.venueName,
        imageUrl= this.imageUrl,
        isFavourite= this.isFavourite,
    )
}