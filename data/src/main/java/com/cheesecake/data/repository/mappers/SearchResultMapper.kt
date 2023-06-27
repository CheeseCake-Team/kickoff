package com.cheesecake.data.repository.mappers

import com.cheesecake.data.local.models.RecentSearchLocalDTO
import com.cheesecake.domain.entity.RecentSearch

@JvmName("searchResultDTOToTeam")
fun RecentSearchLocalDTO.toEntity(): RecentSearch = RecentSearch(
    id = this.id,
    imageUrl = this.imageUrl,
    title = this.title,
    type = this.type,
)

@JvmName("searchResultDTOToTeam")
fun RecentSearch.toLocal(): RecentSearchLocalDTO = RecentSearchLocalDTO(
    id = this.id,
    imageUrl = this.imageUrl,
    title = this.title,
    type = this.type,
    rank = 0
)
