package com.cheesecake.data.remote.models


import com.google.gson.annotations.SerializedName


data class TeamCountriesDTO(
    @SerializedName("code")
    val code: String?,
    @SerializedName("flag")
    val flag: String?,
    @SerializedName("name")
    val name: String
)