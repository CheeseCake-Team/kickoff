package com.cheesecake.presentation.models

data class CountryItemUIState(
    val name: String,
    val flag: String,
    val onClick: () -> Unit
)
