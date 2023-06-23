package com.cheesecake.presentation.screens.homeSearch

import com.cheesecake.domain.entity.League
import com.cheesecake.domain.entity.RecentSearch
import com.cheesecake.domain.entity.RecentSearchType
import com.cheesecake.presentation.screens.search.models.LeagueSearchUIState
import java.net.Authenticator.RequestorType

class RecentSearchUIState(
    val id: Int,
    val imageUrl: String,
    val title: String,
    val type: RecentSearchType,
//    val onClickItem: (RecentSearchUIState) -> Unit,
//    val onClickDelete: () -> Unit
)

fun RecentSearch.toUIState(
//    onClickItem: (RecentSearchUIState) -> Unit,
//    onClickDelete: () -> Unit
) = RecentSearchUIState(
    id = this.id,
    title = this.title,
    imageUrl = this.imageUrl,
    type = this.type,
//    onClickItem = onClickItem,
//    onClickDelete = onClickDelete
)

fun RecentSearchUIState.toEntity() = RecentSearch(
    id = this.id,
    title = this.title,
    imageUrl = this.imageUrl,
    type = this.type,
)

