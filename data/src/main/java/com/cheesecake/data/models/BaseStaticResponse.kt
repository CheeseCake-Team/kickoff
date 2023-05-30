package com.cheesecake.data.models

import com.google.gson.annotations.SerializedName

data class BaseStaticResponse<T>(
    @SerializedName("response")
    val response: T
)
