package com.cheesecake.presentation.screens.homeSearch

data class HomeSearchUIState(
    val data: List<HomeSearchData>? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)