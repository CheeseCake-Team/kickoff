package com.cheesecake.kickoff.models


import com.google.gson.annotations.SerializedName

data class Trophies(
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
        val player: String? = ""
    )

    data class Response(
        @SerializedName("country")
        val country: String? = "",
        @SerializedName("league")
        val league: String? = "",
        @SerializedName("place")
        val place: String? = "",
        @SerializedName("season")
        val season: String? = ""
    )
}