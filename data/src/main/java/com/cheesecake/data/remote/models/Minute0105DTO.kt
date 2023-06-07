package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class Minute0105DTO(
    @SerializedName("0-15")
    val x015: com.cheesecake.data.remote.models.PercentageTotalDTO,
    @SerializedName("106-120")
    val x106120: com.cheesecake.data.remote.models.PercentageTotalDTO,
    @SerializedName("16-30")
    val x1630: com.cheesecake.data.remote.models.PercentageTotalDTO,
    @SerializedName("31-45")
    val x3145: com.cheesecake.data.remote.models.PercentageTotalDTO,
    @SerializedName("46-60")
    val x4660: com.cheesecake.data.remote.models.PercentageTotalDTO,
    @SerializedName("61-75")
    val x6175: com.cheesecake.data.remote.models.PercentageTotalDTO,
    @SerializedName("76-90")
    val x7690: com.cheesecake.data.remote.models.PercentageTotalDTO,
    @SerializedName("91-105")
    val x91105: com.cheesecake.data.remote.models.PercentageTotalDTO
)
