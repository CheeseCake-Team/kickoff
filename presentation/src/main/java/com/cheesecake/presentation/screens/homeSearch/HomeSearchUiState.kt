package com.cheesecake.presentation.screens.homeSearch

data class HomeSearchUiState(
    val data: List<HomeSearchData>? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)