package com.cheesecake.presentation.screens.country


data class CountryUiState(
    val countryName: String = "",
    val imageUrl: String = "",
    val isError: String = "Error",
    val onBackClick: () -> Unit = {}
)