package com.cheesecake.data.models

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("response")
    val response: List<T>
)