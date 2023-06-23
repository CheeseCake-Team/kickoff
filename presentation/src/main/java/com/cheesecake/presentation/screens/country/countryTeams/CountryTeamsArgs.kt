package com.cheesecake.presentation.screens.country.countryTeams

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

class CountryTeamsArgs @Inject constructor(savedStateHandler: SavedStateHandle) {

    val countryName: String = checkNotNull(savedStateHandler[COUNTRY_NAME_ARGS])

    companion object {
        const val COUNTRY_NAME_ARGS = "countryName"
    }

}