package com.cheesecake.data.remote.response


import com.google.gson.annotations.SerializedName


data class TeamCountriesResponse(
    @SerializedName("code")
    val code: String?,
    @SerializedName("flag")
    val flag: String?,
    @SerializedName("name")
    val name: String
)