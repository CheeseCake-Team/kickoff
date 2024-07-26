package com.cheesecake.data.remote.response


import com.google.gson.annotations.SerializedName

data class BasePagingResponse<T>(
    @SerializedName("errors")
    val error: Error,
    @SerializedName("paging")
    val paging: Paging,
    @SerializedName("response")
    val response: List<T>,
    @SerializedName("results")
    val results: Int?
) {
    data class Paging(
        @SerializedName("current")
        val current: Int,
        @SerializedName("total")
        val total: Int
    )

    data class Error(
        @SerializedName("rateLimit")
        val rateLimit: String?,
        @SerializedName("Ip")
        val ip: String?
    )
}