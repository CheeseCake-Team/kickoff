package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class CountryDTO(
    @SerializedName("name")
    val name: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("flag")
    val flag: String
)
