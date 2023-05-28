package com.cheesecake.data.old

import com.google.gson.annotations.SerializedName

data class Goals(
    @SerializedName("away")
    val away: Int? = 0,
    @SerializedName("home")
    val home: Int? = 0
)