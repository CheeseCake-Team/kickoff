package com.cheesecake.data.models


import com.google.gson.annotations.SerializedName


data class TeamCountries(
    @SerializedName("code")
    val code: String?,
    @SerializedName("flag")
    val flag: String?,
    @SerializedName("name")
    val name: String
)