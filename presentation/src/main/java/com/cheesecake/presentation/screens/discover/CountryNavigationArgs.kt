package com.cheesecake.presentation.screens.discover

import androidx.lifecycle.SavedStateHandle
import com.cheesecake.presentation.screens.country.CountryFragmentArgs
import javax.inject.Inject

class CountryNavigationArgs @Inject constructor(savedStateHandler: SavedStateHandle) {

    val countryName: String = CountryFragmentArgs.fromSavedStateHandle(savedStateHandler).countryName
    val imageUrl: String = CountryFragmentArgs.fromSavedStateHandle(savedStateHandler).imageUrl

}