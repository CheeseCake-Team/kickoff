package com.cheesecake.presentation.screens.player.trophyFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.KickoffException
import com.cheesecake.domain.usecases.GetPlayerTrophyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrophyViewModel @Inject constructor(
    private val getPlayerTrophyUseCase: GetPlayerTrophyUseCase
) :ViewModel() {
    private val _state: MutableStateFlow<TrophyUIState> = MutableStateFlow(TrophyUIState())
    val state: StateFlow<TrophyUIState> = _state.asStateFlow()

    init {
        getDate()
    }

    private fun getDate() {
        viewModelScope.launch {
            try {
                _state.update { update ->
                    update.copy(data = getPlayerTrophyUseCase(276),
                        isLoading = false,
                        isError = Pair(false,""))
                }
            }catch (e: KickoffException)
            {
                _state.update { update ->
                    update.copy(data = emptyList(),
                        isLoading = false,
                        isError = Pair(true,e.message.toString()))
                }
            }
        }
    }
}