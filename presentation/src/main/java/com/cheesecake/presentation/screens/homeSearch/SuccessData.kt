package com.cheesecake.presentation.screens.homeSearch

import com.cheesecake.domain.entity.RecentSearch
import kotlinx.coroutines.flow.Flow

data class SuccessData(
    val flow: Flow<List<RecentSearch>>,
    val players: List<HomeSearchData.PlayersTopScorers> = emptyList()
)