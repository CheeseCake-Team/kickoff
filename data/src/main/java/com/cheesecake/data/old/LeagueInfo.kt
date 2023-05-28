package com.cheesecake.data.old

import com.google.gson.annotations.SerializedName

data class LeagueInfo(
    @SerializedName("league")
    val league: League,
    @SerializedName("country")
    val country: Country,
    @SerializedName("seasons")
    val seasons: List<Season>
)








