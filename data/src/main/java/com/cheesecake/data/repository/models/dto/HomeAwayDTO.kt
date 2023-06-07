package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class HomeAwayDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("winner")
    val winner: Boolean
)
