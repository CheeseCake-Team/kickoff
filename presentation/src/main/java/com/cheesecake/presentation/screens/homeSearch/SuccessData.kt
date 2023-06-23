package com.cheesecake.presentation.screens.homeSearch

import com.cheesecake.domain.entity.RecentSearch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class SuccessData(
    val flow: Flow<List<RecentSearch>> = flowOf(),
    val players: List<HomeSearchData.PlayersTopScorers> = emptyList()
)