package com.cheesecake.presentation.widgets.matches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.KickoffException
import com.cheesecake.domain.usecases.GetWidgetMatchesUseCase
import com.cheesecake.presentation.widgets.old.WidgetUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchWidgetViewModel @Inject constructor(
    private val getWidgetMatchesUseCase: GetWidgetMatchesUseCase
):ViewModel() {
    private val _state: MutableStateFlow<WidgetUiState> = MutableStateFlow(WidgetUiState())
    val state: StateFlow<WidgetUiState> = _state.asStateFlow()

    init {
        getDate()
    }

    private fun getDate() {
        try{
            viewModelScope.launch {
                val data = getWidgetMatchesUseCase.invoke("Africa/Egypt",39,2023)
                _state.update {
                    it.copy(data = data,isLoading = false, isError = Pair(false,""))
                }
            }

        }catch (e: KickoffException){
            _state.update {
                it.copy(data = emptyList(),isLoading = false, isError = Pair(true,e.message.toString()))
            }
        }
    }
}