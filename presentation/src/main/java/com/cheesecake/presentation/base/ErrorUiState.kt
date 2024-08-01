package com.cheesecake.presentation.base

import androidx.annotation.DrawableRes

data class ErrorUiState(
    @DrawableRes val imageResource: Int = 0,
    val errorTitle: String = "",
    val errorDescription: String = "",
)