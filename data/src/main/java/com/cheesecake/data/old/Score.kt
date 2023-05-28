package com.cheesecake.data.old

import com.google.gson.annotations.SerializedName

data class Score(
    @SerializedName("extratime")
    val extratime: Extratime? = Extratime(),
    @SerializedName("fulltime")
    val fulltime: Fulltime? = Fulltime(),
    @SerializedName("halftime")
    val halftime: Halftime? = Halftime(),
    @SerializedName("penalty")
    val penalty: Penalty? = Penalty()
) {
    data class Extratime(
        @SerializedName("away")
        val away: Any? = Any(),
        @SerializedName("home")
        val home: Any? = Any()
    )

    data class Fulltime(
        @SerializedName("away")
        val away: Any? = Any(),
        @SerializedName("home")
        val home: Any? = Any()
    )

    data class Halftime(
        @SerializedName("away")
        val away: Int? = 0,
        @SerializedName("home")
        val home: Int? = 0
    )

    data class Penalty(
        @SerializedName("away")
        val away: Any? = Any(),
        @SerializedName("home")
        val home: Any? = Any()
    )
}