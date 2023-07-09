package com.cheesecake.presentation.screens.country


data class CountryUIState(
    val countryName: String = "",
    val imageUrl: String = "",
    val isError: String = "Error",
    val onBackClick: () -> Unit = {}
)