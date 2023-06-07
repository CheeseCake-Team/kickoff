package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class PersonPhotoDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("photo")
    val photo: String
)
