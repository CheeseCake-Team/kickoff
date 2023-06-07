package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class Cards0105DTO(
    @SerializedName("red")
    val red: com.cheesecake.data.remote.models.Minute0105DTO,
    @SerializedName("yellow")
    val yellow: com.cheesecake.data.remote.models.Minute0105DTO
)
