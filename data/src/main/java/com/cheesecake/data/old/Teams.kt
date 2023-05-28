package com.cheesecake.data.old

import com.google.gson.annotations.SerializedName

data class Teams(
    @SerializedName("away")
    val away: Away? = Away(),
    @SerializedName("home")
    val home: Home? = Home()
) {
    data class Away(
        @SerializedName("id")
        val id: Int? = 0,
        @SerializedName("logo")
        val logo: String? = "",
        @SerializedName("name")
        val name: String? = "",
        @SerializedName("winner")
        val winner: Boolean? = false
    )

    data class Home(
        @SerializedName("id")
        val id: Int? = 0,
        @SerializedName("logo")
        val logo: String? = "",
        @SerializedName("name")
        val name: String? = "",
        @SerializedName("winner")
        val winner: Boolean? = false
    )
}