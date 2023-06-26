package com.cheesecake.presentation.widgets.old

import com.cheesecake.domain.entity.Fixture

data class WidgetUiState(
    val data: List<Fixture> = emptyList(),
    val isLoading: Boolean = true,
    val isError: Pair<Boolean, String> = Pair(false, "")
)

