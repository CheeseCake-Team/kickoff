package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class PersonPhoto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("photo")
    val photo: String
)