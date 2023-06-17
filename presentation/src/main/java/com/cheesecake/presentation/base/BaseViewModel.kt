package com.cheesecake.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheesecake.presentation.models.Event
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseViewModel<S, E>(uiState: S, uiEvent: Event<E>) : ViewModel() {

    protected val _state: MutableStateFlow<S> by lazy { MutableStateFlow(uiState) }
    val state: StateFlow<S> by lazy { _state.asStateFlow() }

    protected val _event: MutableStateFlow<Event<E>> by lazy { MutableStateFlow(uiEvent) }
    val event: StateFlow<Event<E>> by lazy { _event.asStateFlow() }

    protected fun <T> tryToExecute(
        call: suspend () -> T,
        onSuccess: (T) -> Unit,
        onError: (Throwable) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                call().also(onSuccess)
            } catch (throwable: Throwable) {
                onError(throwable)
            }
        }
    }

    protected fun <T> collectFlow(
        flow: Flow<T>,
        updateState: S.(T) -> S
    ) {
        viewModelScope.launch {
            flow.collect { value ->
                _state.update { currentState ->
                    currentState.updateState(value)
                }
            }
        }
    }

}