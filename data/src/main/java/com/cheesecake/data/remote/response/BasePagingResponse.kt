package com.cheesecake.data.remote.response


import com.google.gson.annotations.SerializedName

data class BasePagingResponse<T>(
    @SerializedName("errors")
    val errors: List<String>,
    @SerializedName("paging")
    val paging: Paging,
    @SerializedName("response")
    val response: List<T>
) {
    data class Paging(
        @SerializedName("current")
        val current: Int,
        @SerializedName("total")
        val total: Int
    )
}