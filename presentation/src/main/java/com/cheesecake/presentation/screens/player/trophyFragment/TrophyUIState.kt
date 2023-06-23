package com.cheesecake.presentation.screens.player.trophyFragment

import com.cheesecake.domain.entity.Trophy

data class TrophyUIState(
    val data:List<Trophy> = emptyList(),
    val isLoading: Boolean = true,
    val isError: Pair<Boolean,String> = Pair(false,""),
)