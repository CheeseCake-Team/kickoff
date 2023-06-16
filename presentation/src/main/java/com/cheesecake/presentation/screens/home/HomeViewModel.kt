package com.cheesecake.presentation.screens.home

import com.cheesecake.presentation.base.BaseViewModel
import com.cheesecake.presentation.models.Event
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class HomeViewModel: BaseViewModel<HomeUIState, HomeNavigationEvent>(HomeUIState(), Event()) {
}