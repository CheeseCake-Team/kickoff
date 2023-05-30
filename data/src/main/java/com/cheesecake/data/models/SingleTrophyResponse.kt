package com.cheesecake.data.models


import com.google.gson.annotations.SerializedName

data class SingleTrophyResponse(
    @SerializedName("country")
    val country: String,
    @SerializedName("league")
    val league: String,
    @SerializedName("place")
    val place: String,
    @SerializedName("season")
    val season: String
)