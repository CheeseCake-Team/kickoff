package com.cheesecake.data.repository.models.response

import com.google.gson.annotations.SerializedName

data class CountryResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("flag")
    val flag: String
)
