package com.cheesecake.data.models.dto


import com.google.gson.annotations.SerializedName


data class TeamCountriesDTO(
    @SerializedName("code")
    val code: String?,
    @SerializedName("flag")
    val flag: String?,
    @SerializedName("name")
    val name: String
)