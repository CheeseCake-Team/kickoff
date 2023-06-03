package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class Cards(
    @SerializedName("yellow")
    val yellow: Int,
    @SerializedName("yellowred")
    val yellowred: Int,
    @SerializedName("red")
    val red: Int
)
