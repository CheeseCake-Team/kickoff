package com.cheesecake.data.old

import com.google.gson.annotations.SerializedName

data class Fixture(
    @SerializedName("date")
    val date: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("periods")
    val periods: Periods? = Periods(),
    @SerializedName("referee")
    val referee: String? = "",
    @SerializedName("status")
    val status: Status? = Status(),
    @SerializedName("timestamp")
    val timestamp: Int? = 0,
    @SerializedName("timezone")
    val timezone: String? = "",
    @SerializedName("venue")
    val venue: Venue? = Venue()
) {
    data class Periods(
        @SerializedName("first")
        val first: Int? = 0,
        @SerializedName("second")
        val second: Any? = Any()
    )

    data class Status(
        @SerializedName("elapsed")
        val elapsed: Int? = 0,
        @SerializedName("long")
        val long: String? = "",
        @SerializedName("short")
        val short: String? = ""
    )

    data class Venue(
        @SerializedName("city")
        val city: String? = "",
        @SerializedName("id")
        val id: Int? = 0,
        @SerializedName("name")
        val name: String? = ""
    )
}