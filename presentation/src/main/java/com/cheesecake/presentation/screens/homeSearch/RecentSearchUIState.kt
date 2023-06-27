package com.cheesecake.presentation.screens.homeSearch

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.entity.RecentSearch
import com.cheesecake.domain.entity.RecentSearchType
import com.cheesecake.presentation.screens.search.models.LeagueSearchUIState
import java.net.Authenticator.RequestorType

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


