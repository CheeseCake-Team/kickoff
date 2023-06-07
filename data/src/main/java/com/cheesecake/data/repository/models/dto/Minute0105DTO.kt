package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class Minute0105DTO(
    @SerializedName("0-15")
    val x015: PercentageTotalDTO,
    @SerializedName("106-120")
    val x106120: PercentageTotalDTO,
    @SerializedName("16-30")
    val x1630: PercentageTotalDTO,
    @SerializedName("31-45")
    val x3145: PercentageTotalDTO,
    @SerializedName("46-60")
    val x4660: PercentageTotalDTO,
    @SerializedName("61-75")
    val x6175: PercentageTotalDTO,
    @SerializedName("76-90")
    val x7690: PercentageTotalDTO,
    @SerializedName("91-105")
    val x91105: PercentageTotalDTO
)
