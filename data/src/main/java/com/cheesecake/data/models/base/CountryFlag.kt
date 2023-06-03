package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class CountryFlag(
    @SerializedName("name")
    val name: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("flag")
    val flag: String
)
