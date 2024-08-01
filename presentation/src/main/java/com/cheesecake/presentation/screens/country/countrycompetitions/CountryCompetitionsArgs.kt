package com.cheesecake.presentation.screens.country.countrycompetitions

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

class CountryCompetitionsArgs @Inject constructor(savedStateHandler: SavedStateHandle) {
    val countryName: String = checkNotNull(savedStateHandler[COUNTRY_NAME_ARGS])

    companion object {
        const val COUNTRY_NAME_ARGS = "countryName"
    }
}