package com.cheesecake.data.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response


fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> {
    return flow{
        emit(State.Loading)
        try {
            val result = function()
            if (result.isSuccessful) emit(State.Success(result.body()))
            else emit(State.Error(result.message()))
        }catch (e: Exception){
            emit(State.Error(e.message.toString()))
        }
    }
}