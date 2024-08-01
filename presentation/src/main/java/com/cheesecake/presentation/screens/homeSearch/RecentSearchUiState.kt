package com.cheesecake.presentation.screens.homeSearch

import com.cheesecake.domain.entity.RecentSearch
import com.cheesecake.domain.entity.RecentSearchType

class RecentSearchUIState(
    val imageUrl: String,
    val title: String,
    val type: RecentSearchType,
    val onClick: () -> Unit,
)

fun RecentSearch.toUIState(
    onClick: (RecentSearch) -> Unit
) = RecentSearchUIState(
    title = this.title,
    imageUrl = this.imageUrl,
    type = this.type,
    onClick = {onClick(this)},

)


