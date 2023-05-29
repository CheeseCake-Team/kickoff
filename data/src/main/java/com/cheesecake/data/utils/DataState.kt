package com.cheesecake.data.utils

sealed class DataState<out T>{
    data class Success<T>(val data: T):DataState<T>()
    data class Error(val message: String): DataState<Nothing>()
    object Loading : DataState<Nothing>()
}
