package com.cheesecake.data.models


import com.google.gson.annotations.SerializedName
import com.cheesecake.data.models.LeagueResponse.Country

data class CountriesResponse(
    @SerializedName("response")
    val countries: List<Country>
)