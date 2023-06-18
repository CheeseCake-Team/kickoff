package com.cheesecake.presentation.screens.country

import com.cheesecake.presentation.models.TeamCountryUIState


data class CountryUIState(
    val isLoading: Boolean = true,
    val isError: String = "Error"
)