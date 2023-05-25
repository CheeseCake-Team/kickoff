package com.cheesecake.kickoff

import com.google.gson.annotations.SerializedName

data class CountryResponse(
    @SerializedName("get")
    val get: String,
    @SerializedName("parameters")
    val parameters: List<Any>,
    @SerializedName("errors")
    val errors: List<Any>,
    @SerializedName("results")
    val results: Int,
    @SerializedName("paging")
    val paging: Paging,
    @SerializedName("response")
    val response: List<Country>
)

data class Paging(
    @SerializedName("current")
    val current: Int,
    @SerializedName("total")
    val total: Int
)
