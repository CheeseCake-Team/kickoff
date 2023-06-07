package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class CardsDTO(
    @SerializedName("yellow")
    val yellow: Int,
    @SerializedName("yellowred")
    val yellowred: Int,
    @SerializedName("red")
    val red: Int
)
