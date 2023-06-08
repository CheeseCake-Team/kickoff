package com.cheesecake.data.remote.response


import com.google.gson.annotations.SerializedName

data class TrophyResponse(
    @SerializedName("country")
    val country: String,
    @SerializedName("league")
    val league: String,
    @SerializedName("place")
    val place: String,
    @SerializedName("season")
    val season: String
)