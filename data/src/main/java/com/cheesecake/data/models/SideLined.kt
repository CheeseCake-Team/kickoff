package com.cheesecake.data.models

import com.google.gson.annotations.SerializedName

data class SideLined(
    @SerializedName("errors")
    val errors: List<Any?>? = listOf(),
    @SerializedName("get")
    val `get`: String? = "",
    @SerializedName("paging")
    val paging: Paging? = Paging(),
    @SerializedName("parameters")
    val parameters: Parameters? = Parameters(),
    @SerializedName("response")
    val response: List<Response?>? = listOf(),
    @SerializedName("results")
    val results: Int? = 0
) {
    data class Paging(
        @SerializedName("current")
        val current: Int? = 0,
        @SerializedName("total")
        val total: Int? = 0
    )

    data class Parameters(
        @SerializedName("player")
        val player: Int? = 0,
    )

    data class Response(
        @SerializedName("end")
        val end: String? = "",
        @SerializedName("start")
        val start: String? = "",
        @SerializedName("type")
        val type: String? = ""
    )
}