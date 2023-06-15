package com.cheesecake.presentation.ui.match

import com.cheesecake.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class MatchViewModel:BaseViewModel<MatchUIState>(MatchUIState()) {
}