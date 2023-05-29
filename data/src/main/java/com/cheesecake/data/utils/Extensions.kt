package com.cheesecake.data.utils

import com.cheesecake.data.models.BaseResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response


fun <T> wrapWithFlow(request: suspend () -> Response<BaseResponse<T>>): Flow<DataState<List<T>>> {
    return flow{
        emit(DataState.Loading)
        try {
            val result = request()
            if (result.isSuccessful) emit(DataState.Success(result.body()!!.response))
            else emit(DataState.Error(result.message()))
        }catch (e: Exception){
            emit(DataState.Error(e.message.toString()))
        }
    }
}