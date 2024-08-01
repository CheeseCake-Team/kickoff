package com.cheesecake.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheesecake.domain.KickoffException
import com.cheesecake.presentation.R
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

    protected val _errorUiState: MutableStateFlow<ErrorUiState?> by lazy { MutableStateFlow(null) }
    val errorUiState: StateFlow<ErrorUiState?> by lazy { _errorUiState.asStateFlow() }

    protected val _isLoading: MutableStateFlow<Boolean> by lazy { MutableStateFlow(true) }
    val isLoading: StateFlow<Boolean> by lazy { _isLoading.asStateFlow() }

    protected fun <T> tryToExecute(
        call: suspend () -> T,
        onSuccess: (T) -> Unit,
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

    protected fun onError(throwable: Throwable) {
        _isLoading.update { false }
        when (throwable) {
            is KickoffException.IpNotAllowedException -> {
                _errorUiState.update {
                    ErrorUiState(
                        R.drawable.img_unknown_ip_error,
                        "Unknown IP Address !",
                        "This IP is not allowed to call the API, check the list of allowed IPs in the dashboard."
                    )
                }
            }

            is KickoffException.DomainNotAllowedException -> {
                _errorUiState.update {
                    ErrorUiState(
                        R.drawable.img_unknown_domain_error,
                        "Unknown Domain !",
                        "This Domain is not allowed to call the API, check the list of allowed Domains in the dashboard."
                    )
                }
            }

            is KickoffException.RateLimitExceededMinuteException -> {
                _errorUiState.update {
                    ErrorUiState(
                        R.drawable.img_rate_limit_exceed_per_minute_error,
                        "Rate Limit Exceed !",
                        "Too many requests. You have exceeded the limit of requests per minute of your subscription. You can try again after one minute."
                    )
                }
            }

            is KickoffException.RateLimitExceededDayException -> {
                _errorUiState.update {
                    ErrorUiState(
                        R.drawable.img_rate_limit_exceed_per_day_error,
                        "Rate Limit Exceed !",
                        "Too many requests. You have exceeded the limit of requests per day of your subscription."
                    )
                }
            }

            else -> {
                _errorUiState.update {
                    ErrorUiState(
                        R.drawable.img_unkown_error,
                        "An Unexpected Error Occurred !",
                        "Oops! Something went wrong. We couldn't complete your request. Please try again later. If the problem persists, please contact our support team."
                    )
                }
            }
        }
    }

    protected fun <T> tryToExecuteSuspend(
        call: () -> T,
        onSuccess: suspend (T) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                onSuccess(call())
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

    abstract fun getData()
}