package com.cheesecake.presentation.screens.homeSearch

import com.cheesecake.domain.entity.RecentSearch
import com.cheesecake.domain.entity.RecentSearchType

class RecentSearchUIState(
    val id: Int,
    val imageUrl: String,
    val title: String,
    val type: RecentSearchType,
    val onClick: (RecentSearchUIState) -> Unit
)

fun RecentSearch.toUIState(onClick: (RecentSearchUIState) -> Unit) = RecentSearchUIState(
    id = this.id,
    title = this.title,
    imageUrl = this.imageUrl,
    type = this.type,
    onClick = onClick
)

fun RecentSearchUIState.toEntity() = RecentSearch(
    id = this.id,
    title = this.title,
    imageUrl = this.imageUrl,
    type = this.type,
)