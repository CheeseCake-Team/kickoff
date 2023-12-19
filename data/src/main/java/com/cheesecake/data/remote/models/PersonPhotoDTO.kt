package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class PersonPhotoDTO(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("photo")
    val photo: String?
)
