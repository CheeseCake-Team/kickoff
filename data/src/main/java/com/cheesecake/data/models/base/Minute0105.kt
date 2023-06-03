package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class Minute0105(
    @SerializedName("0-15")
    val x015: PercentageTotal,
    @SerializedName("106-120")
    val x106120: PercentageTotal,
    @SerializedName("16-30")
    val x1630: PercentageTotal,
    @SerializedName("31-45")
    val x3145: PercentageTotal,
    @SerializedName("46-60")
    val x4660: PercentageTotal,
    @SerializedName("61-75")
    val x6175: PercentageTotal,
    @SerializedName("76-90")
    val x7690: PercentageTotal,
    @SerializedName("91-105")
    val x91105: PercentageTotal
)
