package com.cheesecake.presentation.models

data class TeamCountryUIState(
    val name: String,
    val flag: String,
    val onClick: (String) -> Unit
)
